package com.green.Shop.member.controller;

import com.green.Shop.member.service.MemberService;
import com.green.Shop.member.vo.MemberVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {

    @Resource(name = "memberService")
    private MemberService memberService;

    //멤버리스트 조회
    @GetMapping("/memberList")
    public List<MemberVO> getMemberList(){
        return memberService.getMemberList();
    }

    //아이디 중복 조회
    @GetMapping("/checkId/{memId}")
    public boolean checkId(@PathVariable("memId")String memId){
        log.info(memId);
        return memberService.chkId(memId);
    }

    //멤버 등록
    @PostMapping("/insert")
    public void insert(@RequestBody MemberVO memberVO){
        System.out.println(memberVO);
        memberService.insert(memberVO);
    }

    //아이디 비밀번호 중복확인
    @PostMapping("/checkIdPw")
    public MemberVO checkIdPw(@RequestBody MemberVO memberVO){
        System.out.println(memberVO);
        return memberService.checkIdPw(memberVO);
    }


}
