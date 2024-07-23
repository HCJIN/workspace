package com.green.Board.service;

import com.green.Board.vo.BoardVO;
import com.green.Board.vo.MemberVO;

import java.util.List;

public interface MemberService {

    /* 아이디 중복 체크 */
    boolean chkId(String memId);

    /* 아이디 비밀번호 체크 */
    MemberVO chkIdPw(MemberVO memberVO);

    void insert(MemberVO memberVO);

    List<MemberVO> getMember();
}
