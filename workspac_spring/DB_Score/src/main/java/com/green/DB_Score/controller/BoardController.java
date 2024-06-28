package com.green.DB_Score.controller;

import com.green.DB_Score.service.BoardServiceImpl;
import com.green.DB_Score.vo.BoardVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {

    @Resource(name="boardService")
    private BoardServiceImpl boardService;

    List<BoardVO> boardList = new ArrayList<>();

    @GetMapping("/board")
    public String board(Model model){
        boardList = boardService.select();
        model.addAttribute("boardDB",boardList);
        System.out.println(boardList);
        return "board_list";
    }

    @GetMapping("/writeForm")
    public String writeForm(){
        return "board_write_form";
    }

    @PostMapping("/boardUpload")
    public String boardUpload(BoardVO boardVO){
        boardService.insert(boardVO);
        boardList.add(boardVO);
        return "redirect:/board";
    }

    @GetMapping("/boardDetail")
    public String boardDetail(@RequestParam(name = "boardNum") int boardNum,Model model){
        BoardVO board = boardService.detail(boardNum);
        model.addAttribute("boardDB",board);
        boardService.readUpdate(boardNum);
        return "board_detail";
    }

    @GetMapping("/boardDelete")
    public String boardDelete(@RequestParam(name = "boardNum")int boardNum, Model model){
        boardService.delete(boardNum);
        return "redirect:/board";
    }

    @GetMapping("/updateForm2")
    public String updateForm(@RequestParam(name = "boardNum")int boardNum, Model model){
        BoardVO board = boardService.detail(boardNum);
        model.addAttribute("boardDB",board);
        return "update_form";
    }

    @PostMapping("/upload2")
    public String upload2(BoardVO boardVO, @RequestParam(name = "boardNum")int boardNum, Model model){
        BoardVO board = new BoardVO();
        board.setBoardNum(boardNum);
        board.setTitle(boardVO.getTitle());
        board.setWriter(boardVO.getWriter());
        board.setContent(boardVO.getContent());
        board.setReadCnt(boardVO.getReadCnt());
        boardService.update(board);
        return "redirect:/boardDetail?boardNum=" + boardNum;
    }
}
