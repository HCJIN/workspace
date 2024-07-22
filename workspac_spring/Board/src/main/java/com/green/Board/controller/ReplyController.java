package com.green.Board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reply")
public class ReplyController {

    //댓글 목록
    @GetMapping("/list")
    public String getReplyList(){
        return "댓글 목록";
    }


}
