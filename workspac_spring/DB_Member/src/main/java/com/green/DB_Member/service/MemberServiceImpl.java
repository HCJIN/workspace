package com.green.DB_Member.service;

import com.green.DB_Member.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//MemberService 인터페이스의 추상메소드를 구현한 클래스
//해당 클래스에서는 데이터베이스 쿼리 작업을 진행한다.
//Mybatis 를 이용해 쿼리 작업을 하기 위해서는
//SqlSessionTemplate 클래스의 객체가 필요하다.
//SqlSessionTemplate 클래스에는 쿼리 작업을 위한 메소드가 정의되어 있다.
@Service("memberService")
public class MemberServiceImpl implements MemberService{

    @Autowired
    private SqlSessionTemplate sqlSession;

    //회원 정보 등록
    @Override
    public void insertMember(MemberVO memberVO) {
        //첫번째 매개변수 : namespace.쿼리 id
        //두번째 매개변수 : 쿼리 실행 시 빈값을 채워줄 데이터
        sqlSession.insert("memberMapper.insertMember", memberVO);
    }
}
