package com.green.Shop.member.service;

import com.green.Shop.member.vo.MemberVO;

import java.util.List;

public interface MemberService {

    List<MemberVO> getMemberList();

    boolean chkId(String memId);

    void insert(MemberVO memberVO);

    //아이디 비밀번호 중복체크
    MemberVO checkIdPw(MemberVO memberVO);
}
