package com.green.DB_Member.service;

import com.green.DB_Member.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbService")
public class DBServiceImpl implements DBService{

    @Autowired
    private SqlSessionTemplate sqlSession;

    // 실행할 쿼리가 select 면 selectOne(), selectList() 메소드 중 하나 사용!
    // 조회 결과 데이터가 0행 혹은 1행이면 selectOne() 사용
    // 조회 결과 데이터의 행 개수가 고정되지 않으면 selectList() 사용
    // 회원번호가 1번인 회원의 이름을 조회하는 쿼리를 실행할 메소드 오버라이딩
    @Override
    public String select1() {
        String name =  sqlSession.selectOne("dbMapper.select1");
        return name;
    }

    @Override
    public int select2(int memNum) {
        int age = sqlSession.selectOne("dbMapper.select2",memNum);
        return age;
    }

    @Override
    public List<String> select3(int memAge) {
        List<String> nameList = sqlSession.selectList("dbMapper.select3",memAge);
        return nameList;
    }

    @Override
    public MemberVO select4(int memNum) {
        MemberVO memberVO = sqlSession.selectOne("dbMapper.select4",memNum);
        return memberVO;
    }

    @Override
    public List<MemberVO> select5() {
        List<MemberVO> memberVO = sqlSession.selectList("dbMapper.select5");
        return memberVO;
    }

    @Override
    public int delete(int memNum) {
        int num = sqlSession.delete("dbMapper.delete", memNum);
        return num;
    }

    @Override
    public void insert(MemberVO memberVO) {
        sqlSession.insert("dbMapper.insert", memberVO);
    }

    @Override
    public int update(MemberVO memberVO) {
        int num = sqlSession.update("dbMapper.update",memberVO);
        return num;
    }


}
