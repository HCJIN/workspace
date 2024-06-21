package com.green.DataPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ATagController {

    @GetMapping("/a1")
    public String a1(Model model){
        model.addAttribute("stuName","kim");
        model.addAttribute("score",80);
        return "a1";
    }

    @GetMapping("/a2")
    public String a2(@RequestParam(name="address")String name, Model model){
        System.out.println("name = " + name);
        model.addAttribute("name",name);
        return "a2";
    }

    @GetMapping("/a3")
    public String a3(@RequestParam(name="name")String name,
                     @RequestParam(name="age")int age){
        System.out.println("name = " + name);
        System.out.println("age = " + age);
       return "a3";
    }





}
