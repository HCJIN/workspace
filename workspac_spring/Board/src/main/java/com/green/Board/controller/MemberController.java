package com.green.Board.controller;

import com.green.Board.service.MemberService;
import com.green.Board.vo.BoardVO;
import com.green.Board.vo.MemberVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource(name = "memberService")
    private MemberService memberService;

    //회원가입 데이터 입력
    @PostMapping("/join")
    public void insert(@RequestBody MemberVO memberVO){
        System.out.println(memberVO);
        memberService.insert(memberVO);
    }






}
