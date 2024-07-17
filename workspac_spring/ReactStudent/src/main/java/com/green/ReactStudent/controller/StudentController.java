package com.green.ReactStudent.controller;

import com.green.ReactStudent.service.ReactStudentImpl;
import com.green.ReactStudent.service.ReactStudentService;
import com.green.ReactStudent.vo.StudentVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Resource(name = "reactStudent")
    private ReactStudentService reactStudent;

    //목록 조회
    @GetMapping("/getMain")
    public List<StudentVO> getStudentList(){
        System.out.println(reactStudent.getStudent());
        return reactStudent.getStudent();
    }

    //학생 등록
    @PostMapping("/insert")
    public void insert(@RequestBody StudentVO studentVO){
        reactStudent.inStudent(studentVO);
        System.out.println(studentVO);
    }

    //성적 등록 페이지
    @GetMapping("/score/{stuNum}")
    public StudentVO score(@PathVariable("stuNum")int stuNum){
        return reactStudent.detailScore(stuNum);
    }

    //점수 등록
    @PostMapping("/update")
    public void update(@RequestBody StudentVO studentVO){
        reactStudent.update(studentVO);
        System.out.println(studentVO);
    }

    //학생 삭제
    @DeleteMapping("/delete/{stuNum}")
    public void delete(@PathVariable("stuNum")int stuNum){
        System.out.println(stuNum);
        reactStudent.delete(stuNum);
    }









}
