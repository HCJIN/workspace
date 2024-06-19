package com.green.DataPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {

    @GetMapping("/a")
    public String inputName(){

        return "/join/test1";
    }

    @PostMapping("/b")
    public String inputAge(@RequestParam(name = "name") String name, Model model){
        System.out.println(name);
        model.addAttribute("name",name);
        return "/join/test2";
    }

    @PostMapping("/c")
    public String show(@RequestParam(name ="name") String name, @RequestParam(name="age") int age, Model model){
        System.out.println(name + age);
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        return "/join/test3";
    }



}
