package com.green.DB_Score.service;

import com.green.DB_Score.vo.StudentScoreVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public List<StudentScoreVO> select() {
        List<StudentScoreVO> list = sqlSession.selectList("scoreMapper.select");
        return list;
    }

    @Override
    public void insert(StudentScoreVO studentScoreVO) {
        sqlSession.insert("scoreMapper.insert",studentScoreVO);
    }

    @Override
    public StudentScoreVO detail(int stuNum) {
        StudentScoreVO studentScore = sqlSession.selectOne("scoreMapper.detail",stuNum);
        return studentScore;
    }

    @Override
    public void update(StudentScoreVO studentScoreVO) {
        sqlSession.update("scoreMapper.update",studentScoreVO);
    }

    @Override
    public void delete(int stuNum) {
        sqlSession.delete("scoreMapper.delete",stuNum);
    }


}
