package com.green.Board.controller;

import com.green.Board.service.BoardService;
import com.green.Board.service.BoardServiceImpl;
import com.green.Board.vo.BoardVO;
import com.green.Board.vo.SearchVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@Slf4j
public class BoardController {

    @Resource(name = "boardService")
    private BoardService boardService;

    //게시글 목록
    @GetMapping("/list")
    public String getBoardList(){
        return "게시글 목록";
    }

    //게시글 목록 조회
    @PostMapping("/boardList")
    public List<BoardVO> boardList(@RequestBody SearchVO searchVO){
        log.info(searchVO.toString());
        return boardService.getBoardList(searchVO);
    }

    //게시글 등록
    @PostMapping("/inBoard")
    public void inBoard(@RequestBody BoardVO boardVO){
        System.out.println(boardVO);
        boardService.inBoard(boardVO);
    }

    //디테일 조회
    @GetMapping("/detail/{boardNum}")
    public BoardVO detail(@PathVariable("boardNum")int boardNum){
        return boardService.getBoard(boardNum);
    }

    //게시글 수정
    @PostMapping("/update/{boardNum}")
    public void update(@RequestBody BoardVO boardVO){
        boardService.update(boardVO);
    }

    //게시글 삭제
    @DeleteMapping("/delete/{boardNum}")
    public void delete(@PathVariable("boardNum")int boardNum){
        boardService.delete(boardNum);
    }


}
