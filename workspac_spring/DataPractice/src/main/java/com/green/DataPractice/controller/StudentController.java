package com.green.DataPractice.controller;

import com.green.DataPractice.vo.StudentVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @GetMapping("/student")
    public String student(){
        return "student";
    }

    @PostMapping("/score")
    public String score(@RequestParam(name="name")String name,Model model){
        model.addAttribute("name",name);
        return "score";
    }

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
