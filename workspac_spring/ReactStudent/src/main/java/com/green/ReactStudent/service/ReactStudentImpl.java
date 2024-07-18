package com.green.ReactStudent.service;

import com.green.ReactStudent.vo.StudentVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("reactStudent")
public class ReactStudentImpl implements ReactStudentService{

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<StudentVO> getStudent() {
        return sqlSession.selectList("studentMapper.getStudent");
    }

    @Override
    public StudentVO detail(int stuNum) {
        return sqlSession.selectOne("studentMapper.detail",stuNum);
    }

    @Override
    public void inStudent(StudentVO studentVO) {
        sqlSession.insert("studentMapper.inStudent",studentVO);
    }

    @Override
    public StudentVO detailScore(int stuNum) {
        return sqlSession.selectOne("studentMapper.detailScore",stuNum);
    }

    @Override
    public void update(StudentVO studentVO) {
        sqlSession.update("studentMapper.update",studentVO);
    }

    @Override
    public void delete(int stuNum) {
        sqlSession.delete("studentMapper.delete",stuNum);
    }
}
