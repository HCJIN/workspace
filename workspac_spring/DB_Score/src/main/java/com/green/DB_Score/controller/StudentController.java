package com.green.DB_Score.controller;

import com.green.DB_Score.service.StudentServiceImpl;
import com.green.DB_Score.vo.StudentScoreVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Resource(name="studentService")
    private StudentServiceImpl studentService;

    List<StudentScoreVO> studentScoreList = new ArrayList<>();

    //학생정보 가져오기
    @GetMapping("/list")
    public String list(Model model){
        List<StudentScoreVO> list = studentService.select();
        model.addAttribute("stuDB", list);
        return "stu_list";
    }

    //학생정보 등록하기
    @GetMapping("/regStudent")
    public String regStudent(){
        return "reg_student";
    }

    @PostMapping("/upload")
    public String upload(StudentScoreVO studentScoreVO){
        studentService.insert(studentScoreVO);
        studentScoreList.add(studentScoreVO);
        return "redirect:/list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(name = "stuNum")int stuNum, Model model){

        StudentScoreVO student = studentService.detail(stuNum);
        model.addAttribute("stuDB",student);

        return "student_detail";
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam(name = "stuNum")int stuNum, Model model){

        StudentScoreVO student = studentService.detail(stuNum);
        model.addAttribute("stuDB",student);

        return "update_student";
    }

    @PostMapping("/update")
    public String update(StudentScoreVO studentScoreVO, @RequestParam(name = "stuNum")int stuNum){
        StudentScoreVO student = new StudentScoreVO();
        student.setStuNum(stuNum);
        student.setStuName(studentScoreVO.getStuName());
        student.setKorScore(studentScoreVO.getKorScore());
        student.setEngScore(studentScoreVO.getEngScore());
        student.setIntro(studentScoreVO.getIntro());
        studentService.update(student);

        return "redirect:/detail?stuNum=" + stuNum;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "stuNum")int stuNum){
        studentService.delete(stuNum);
        return "redirect:/list";
    }
}
