package com.green.DataPractice.controller;

import com.green.DataPractice.vo.SurveyVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SurveyController {

    @GetMapping("/survey")
    public String survey(){
        return "survey";
    }

    @PostMapping("/result")
    public String result(SurveyVO surveyVO, Model model){
        model.addAttribute("survey",surveyVO);
        System.out.println(surveyVO);
        return "survey_result";
    }
}
