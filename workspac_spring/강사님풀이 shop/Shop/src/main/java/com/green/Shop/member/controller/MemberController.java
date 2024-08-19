package com.green.Shop.member.controller;

import com.green.Shop.member.service.MemberService;
import com.green.Shop.member.vo.MemberVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api_member")
public class MemberController {

    @Resource(name = "memberService")
    private MemberService memberService;

    //회원가입
    @PostMapping("/join")
    public void join(@RequestBody MemberVO memberVO){
        memberService.join(memberVO);
    }

    //아이디중복 조회
    @GetMapping("/isEnableId/{memId}")
    public boolean isEnableId(@PathVariable("memId") String memId){
        //사용가능 id -> result : true
        return memberService.isEnableId(memId);
    }

    //로그인
    @PostMapping("/login")
    public MemberVO login(@RequestBody MemberVO memberVO){
        System.out.println(memberService.login(memberVO));
        return memberService.login(memberVO);
    }
}
