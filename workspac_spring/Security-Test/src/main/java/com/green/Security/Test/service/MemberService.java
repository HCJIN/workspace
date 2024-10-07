package com.green.Security.Test.service;

import com.green.Security.Test.vo.MemberVO;

public interface MemberService {

    void test1();

    //회원가입
    void join(MemberVO memberVO);

    //로그인 하려는 회원의 정보 조회
    MemberVO getMemberForLogin(String memId);
}
