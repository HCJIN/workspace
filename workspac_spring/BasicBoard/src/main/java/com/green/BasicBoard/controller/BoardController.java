package com.green.BasicBoard.controller;

import com.green.BasicBoard.service.BoardServiceImpl;
import com.green.BasicBoard.vo.BoardVO;
import com.green.BasicBoard.vo.SearchVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {

    @Resource(name = "boardService")
    private BoardServiceImpl boardService;

    List<BoardVO> boardList = new ArrayList<>();

    @RequestMapping("/list")
    public String board(Model model, SearchVO searchVO){
        //searchVO 데이터 검사
        System.out.println(searchVO);

        //목록조회
        boardList =  boardService.select(searchVO);
        model.addAttribute("boardList", boardList);
        return "board_list";
    }

    // 게시글 작성페이지 이동
    @GetMapping("/writeForm")
    public String writeForm(){
        return "write_form";
    }

    // 게시글 등록후 메인페이지 이동
    @PostMapping("/upload")
    public String board(BoardVO boardVO){
        boardService.insert(boardVO);
        boardList.add(boardVO);
        return "redirect:/list";
    }

    // 게시글 제목 입력시 상세페이지 이동
    @GetMapping("/boardDetail")
    public String boardDetail(BoardVO boardVO, Model model){
        BoardVO board = boardService.detail(boardVO.getBoardNum());
        model.addAttribute("boardDB",board);
        boardService.update2(boardVO.getBoardNum());
        return "board_detail";
    }

    //상세페이지에서 수정 클릭시 수정페이지 이동
    @GetMapping("/update_form")
    public String updateForm(BoardVO boardVO,Model model){
        BoardVO board = boardService.detail(boardVO.getBoardNum());
        model.addAttribute("boardDB",board);
        return "update_form";
    }

    // 수정후 상세페이지 이동
    @PostMapping("/update")
    public String update(@RequestParam(name = "boardNum")int boardNum, Model model, BoardVO boardVO){
        BoardVO board = new BoardVO();
        board.setBoardNum(boardNum);
        board.setTitle(boardVO.getTitle());
        board.setWriter(boardVO.getWriter());
        board.setContent(boardVO.getContent());
        board.setDate(boardVO.getDate());
        board.setReadCnt(boardVO.getReadCnt());
        boardService.update(boardVO);
        return "redirect:/boardDetail?boardNum=" + boardNum;
    }

    //게시글 삭제 후 목록페이지 이동
    @GetMapping("/delete")
    public String delete(@RequestParam(name="boardNum")int boardNum,BoardVO boardVO, Model model){
        boardService.delete(boardNum);
        return "redirect:/list";
    }

}
