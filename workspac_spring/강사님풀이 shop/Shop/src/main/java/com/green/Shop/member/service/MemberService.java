package com.green.Shop.member.service;

import com.green.Shop.member.vo.MemberVO;

import java.util.List;

public interface MemberService {

    List<MemberVO> getMemberList();

    //아이디 중복확인
    boolean isEnableId(String memId);

    //회원 가입
    void join(MemberVO memberVO);

    //로그인
    MemberVO login(MemberVO memberVO);
}
