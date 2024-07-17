package com.green.ReactStudent.service;

import com.green.ReactStudent.vo.StudentVO;

import java.util.List;

public interface ReactStudentService {

    List<StudentVO> getStudent();

    void inStudent(StudentVO studentVO);

    StudentVO detailScore(int stuNum);

    void update(StudentVO studentVO);

    void delete(int stuNum);
}
