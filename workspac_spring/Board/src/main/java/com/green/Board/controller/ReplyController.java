package com.green.Board.controller;

import com.green.Board.service.ReplyService;
import com.green.Board.vo.ReplyVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Resource(name = "replyService")
    private ReplyService replyService;

    //댓글 목록
    @GetMapping("/list/{boardNum}")
    public List<ReplyVO> getReplyList(@PathVariable("boardNum")int boarNum){
        System.out.println(replyService.getReplyList(boarNum));
        return replyService.getReplyList(boarNum);
    }

    //댓글 등록
    @PostMapping("/insert")
    public void insert(@RequestBody ReplyVO replyVO){
        System.out.println(replyVO);
        replyService.insert(replyVO);
    }

    //댓글 삭제
    @DeleteMapping("/delete/{replyNum}")
    public void delete(@PathVariable("replyNum")int replyNum){
        replyService.delete(replyNum);
    }

    @DeleteMapping("/delete2/{boardNum}")
    public void delete2(@PathVariable("boardNum")int boardNum){
        replyService.delete2(boardNum);
    }
}
