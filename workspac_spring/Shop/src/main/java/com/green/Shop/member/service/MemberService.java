package com.green.Shop.member.service;

import com.green.Shop.member.vo.MemberVO;

import java.util.List;

public interface MemberService {

    List<MemberVO> getMemberList();

    boolean chkId(String memId);

    //회원 가입
    void join(MemberVO memberVO);
}
