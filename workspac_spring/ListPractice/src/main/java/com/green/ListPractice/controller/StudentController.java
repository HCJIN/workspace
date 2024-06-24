package com.green.ListPractice.controller;

import com.green.ListPractice.service.StudentService;
import com.green.ListPractice.vo.BoardVO;
import com.green.ListPractice.vo.StudentVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    StudentService studentService = new StudentService();


    @GetMapping("/list3")
    public String stuList(Model model){
        //학생 목록 데이터 받아오기
        List<StudentVO> list = studentService.getStuList();
        model.addAttribute("studentList",list);
        return "stu_list";
    }

    @GetMapping("/regStudent")
    public String regStudent(){
        return "reg_student";
    }

    @PostMapping("/join")
    public String join(StudentVO studentVO,Model model){
        studentService.regStudent(studentVO);
        return "redirect:/list3";
    }

    @GetMapping("/stuDetail")
    public String stuDetail(@RequestParam(name="studentNum") int studentNum, Model model){
        //내가 클릭한 학생 한명을 검색(학번을 알면 된다)
        StudentVO student = studentService.getStuDetail(studentNum);
        //학생 상세 정보 데이터를 html 로 전달
        model.addAttribute("student",student);
        return "student_detail";
    }

    @GetMapping("/stuDelete")
    public String stuDelete(@RequestParam(name="studentNum") int studentNum){
        studentService.getStuDelete(studentNum);

        return "redirect:/list3";
    }

    //학생 정보 수정 페이지
    @GetMapping("/updateForm")
    public String update(@RequestParam(name="studentNum") int studentNum, Model model){

        //정보를 수정할 학생의 원래 정보를 html 에 전달
        //1. 정보를 수정할 학생 한 명을 pick!
        StudentVO student = studentService.getStuDetail(studentNum);
        //2. 수정할 학생을 html 로 전달
        model.addAttribute("student",student);

        return "update_student";

    }

    @PostMapping("/correction")
    public String correction(StudentVO studentVO, Model model){
        studentService.getCorrection(studentVO);
        return "redirect:/stuDetail?studentNum=" + studentVO.getStudentNum();
    }


}
