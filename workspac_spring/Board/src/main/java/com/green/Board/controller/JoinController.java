package com.green.Board.controller;

import com.green.Board.service.JoinService;
import com.green.Board.vo.BoardVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/join")
public class JoinController {

    @Resource(name = "joinService")
    private JoinService joinService;

    @GetMapping("/bbb")
    public List<BoardVO> bbb(){
        return joinService.bbb();
    }

    @GetMapping("/ccc")
    public BoardVO ccc(){
        return joinService.ccc();
    }




}
