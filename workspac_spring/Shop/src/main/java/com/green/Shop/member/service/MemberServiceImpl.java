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

    @Override
    public boolean chkId(String memId) {
        //id가 null 이면 회원가입 가능
        //id가 조회되면 null 이 아니기 때문에 회원가입 불가능
        return sqlSession.selectOne("memberMapper.chkId",memId) != null;
    }

    //회원 가입
    @Override
    public void join(MemberVO memberVO) {
        sqlSession.insert("memberMapper.join",memberVO);
    }
}
