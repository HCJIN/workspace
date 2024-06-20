package com.green.DataPractice.controller;

import com.green.DataPractice.vo.StudentVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    //시작페이지로 이동
    @GetMapping("/student")
    public String student(){
        return "student";
    }

    //학생이름을 입력받아 두번째 페이지로 이동
    @PostMapping("/score")
    public String score(@RequestParam(name="name")String name,Model model){
        model.addAttribute("name",name);
        return "score";
    }

    //학년, 성별, 연락처 입력받아 세번째 페이지로 이동
    @PostMapping("/scoreIn")
    public String scoreIn(@RequestParam(name="name")String name,
                          @RequestParam(name="classNum") String classNum,
                          @RequestParam(name = "path") String path,
                          @RequestParam(name ="tel") String tel,Model model,
                          @RequestParam(name = "gender") String gender){
        model.addAttribute("name",name);
        model.addAttribute("classNum",classNum);
        model.addAttribute("path",path);
        model.addAttribute("tel",tel);
        model.addAttribute("gender",gender);
        return "scoreIn";
    }

    //출력페이지로 이동
    @PostMapping("/final")
    public String studentFinal(@RequestParam(name="name")String name,
                               @RequestParam(name="classNum") String classNum,
                               @RequestParam(name = "path") String path,
                               @RequestParam(name ="tel") String tel,
                               @RequestParam(name="ko") int ko,
                               @RequestParam(name = "en") int en,
                               @RequestParam(name = "gender") String gender,
                               @RequestParam(name ="math") int math,
                               Model model){
        double avg = (ko+en+math) / 3.0;
        model.addAttribute("name",name);
        model.addAttribute("classNum",classNum);
        model.addAttribute("path",path);
        model.addAttribute("tel",tel);
        model.addAttribute("ko",ko);
        model.addAttribute("en",en);
        model.addAttribute("math",math);
        model.addAttribute("total",avg);
        model.addAttribute("gender",gender);
        return "studentFinal";
    }








}
