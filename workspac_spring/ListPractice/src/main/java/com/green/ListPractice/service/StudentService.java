package com.green.ListPractice.service;

import com.green.ListPractice.vo.StudentVO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

//학생관리 프로그램의 핵심 기능을 정의
public class StudentService {

    List<StudentVO> studentList = new ArrayList<>();

    //학생 목록 조회
    public List<StudentVO> getStuList(){
        return studentList;
    }

    //학생 등록
    public void regStudent(StudentVO studentVO){
        studentList.add(studentVO);
    }

    //학생 상세 조회
    public StudentVO getStuDetail(int studentNum){
        //학번이 일치하는 학생을 저장할 공간.
        StudentVO findStudent = null;
        for (StudentVO studentVO : studentList){
            if (studentVO.getStudentNum() == studentNum){
                findStudent = studentVO;
            }
        }
        return findStudent;
    }

    //학생 삭제
    public void getStuDelete(int studentNum){
        int index = 0;
        for (int i = 0; i < studentList.size(); i++){
            if (studentNum == studentList.get(i).getStudentNum()){
                index = i;
            }
        }
        studentList.remove(index);
    }

    //학생 정보 수정
    public void getCorrection(StudentVO studentVO){
//        for (int i = 0; i < studentList.size(); i++) {
//            if (studentNum == studentList.get(i).getStudentNum()) {
//                studentList.get(i).setName(studentVO.getName());
//                studentList.get(i).setKo(studentVO.getKo());
//                studentList.get(i).setEn(studentVO.getEn());
//                studentList.get(i).setIntro(studentVO.getIntro());
//            }
//        }

        for (StudentVO student  : studentList){
            if (student.getStudentNum() == studentVO.getStudentNum()){
                student.setName(studentVO.getName());
                student.setKo(studentVO.getKo());
                student.setEn(studentVO.getEn());
                student.setIntro(studentVO.getIntro());
            }
        }
    }


}
