package com.green.Board.controller;

import com.green.Board.service.MemberService;
import com.green.Board.vo.BoardVO;
import com.green.Board.vo.MemberVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // 로그 남길 때 쓰는 어노테이션, 모든 클래스 위에 사용 가능
@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource(name = "memberService")
    private MemberService memberService;

    //아이디 중복 확인
    @GetMapping("/checkId/{inputId}")
    public boolean checkId(@PathVariable("inputId") String inputId){
        log.info(inputId);
        // ture -> 불가능
        // false -> 가능
        return memberService.chkId(inputId);
    }

    //아이디 비밀번호 중복 확인
    @PostMapping("/checkIdPw")
    public MemberVO login(@RequestBody MemberVO memberVO){
        //조회된 데이터가 없으면 member 는 null 이 된다!
        MemberVO member = memberService.chkIdPw(memberVO);
        System.out.println(member);
        return member;
    }

    //회원가입 데이터 입력
    @PostMapping("/join")
    public void insert(@RequestBody MemberVO memberVO){;
        System.out.println(memberVO);
        memberService.insert(memberVO);
    }

    //아이디 리스트 조회
    @GetMapping("/list")
    public List<MemberVO> getMemberList(){
        MemberVO memberVO = new MemberVO();
        System.out.println(memberVO);
        return memberService.getMember();
    }




}
