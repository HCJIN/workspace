package com.green.Shop.member.service;

import com.green.Shop.member.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<MemberVO> getMemberList() {
        return sqlSession.selectList("memberMapper.getMemberList");
    }

    //아이디 중복확인
    //사용 가능 : true, 사용 불가 : false
    @Override
    public boolean isEnableId(String memId) {
        //id가 null 이면 회원가입 가능 true
        //id가 조회되면 null 이 아니기 때문에 회원가입 불가능 false
        String selectedId = sqlSession.selectOne("memberMapper.isEnableId",memId);
        return selectedId == null;
    }

    //회원 가입
    @Override
    public void join(MemberVO memberVO) {
        sqlSession.insert("memberMapper.join",memberVO);
    }

    //로그인
    @Override
    public MemberVO login(MemberVO memberVO) {
        return sqlSession.selectOne("memberMapper.login",memberVO);
    }
}
