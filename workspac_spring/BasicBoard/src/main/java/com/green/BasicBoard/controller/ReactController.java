package com.green.BasicBoard.controller;

import com.green.BasicBoard.service.BoardServiceImpl;
import com.green.BasicBoard.vo.BoardVO;
import com.green.BasicBoard.vo.SearchVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReactController {

    @Resource(name = "boardService")
    private BoardServiceImpl boardService;

    List<BoardVO> boardList = new ArrayList<>();

    @RequestMapping("/list2")
    public List<BoardVO> board(Model model, SearchVO searchVO){

        //목록조회
        boardList =  boardService.select(searchVO);

        return boardList;
    }

}
