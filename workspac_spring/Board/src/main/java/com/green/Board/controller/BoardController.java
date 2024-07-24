package com.green.Board.controller;

import com.green.Board.service.BoardService;
import com.green.Board.vo.BoardVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Resource(name = "boardService")
    private BoardService boardService;

    //게시글 목록
    @GetMapping("/list")
    public String getBoardList(){
        return "게시글 목록";
    }

    //게시글 목록 조회
    @GetMapping("/boardList")
    public List<BoardVO> boardList(){
        return boardService.getBoardList();
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


}
