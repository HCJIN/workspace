package com.green.DB_Score.service;

import com.green.DB_Score.vo.StudentScoreVO;

import java.util.List;

public interface StudentService {

    List<StudentScoreVO> select();

    void insert(StudentScoreVO studentScoreVO);

    StudentScoreVO detail(int stuNum);

    void update(StudentScoreVO studentScoreVO);

    void delete(int stuNum);
}
