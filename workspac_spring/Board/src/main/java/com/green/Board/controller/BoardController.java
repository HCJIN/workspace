package com.green.Board.controller;

import com.green.Board.service.BoardService;
import com.green.Board.vo.BoardVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
