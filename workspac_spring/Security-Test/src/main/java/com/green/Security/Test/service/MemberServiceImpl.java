package com.green.Security.Test.service;

import com.green.Security.Test.vo.MemberVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
@RequiredArgsConstructor // final 이 붙어있는 변수를 매개변수로 갖는 생성자
public class MemberServiceImpl implements MemberService{

    //생성자 주입
    //기존과 달라진점
    //1. 선언한 객체 위에 어노테이션 삭제
    //2. 선언한 변수에 final 키워드가 붙는다.
    //3. 클래스에 @RequiredArgsConstructor 어노테이션이 붙는다.
    private final SqlSessionTemplate sqlSession;



    @Override
    public void test1() {
        System.out.println(111);
    }

    //회원가입
    @Override
    public void join(MemberVO memberVO) {
        sqlSession.insert("memberMapper.join",memberVO);
    }
}
