package com.green.Board.service;

import com.green.Board.vo.BoardVO;
import com.green.Board.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public boolean chkId(String memId) {
        //id가 null 이면 회원가입 가능
        //id가 조회되면 (null 아니면) 회원가입 불가능
        return sqlSession.selectOne("memberMapper.chkId",memId) != null;
    }

    @Override
    public MemberVO chkIdPw(MemberVO memberVO) {
        return sqlSession.selectOne("memberMapper.chkIdPw",memberVO);
    }

    @Override
    public void insert(MemberVO memberVO) {
        sqlSession.insert("memberMapper.insert",memberVO);
    }

    @Override
    public List<MemberVO> getMember() {
        return sqlSession.selectList("memberMapper.getMember");
    }
}
