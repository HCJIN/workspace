package com.green.DataPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChickenController {


    @GetMapping("/order")
    public String chicken(){
        return "order";
    }

    @PostMapping("/delivery")
    public String delivery(@RequestParam(name = "chicken") String chicken,
                           @RequestParam(name = "num") int num,
                           @RequestParam(name = "check") String check,
                           @RequestParam(name = "review") String review,
                           Model model){
        model.addAttribute("chicken",chicken);
        model.addAttribute("num",num);
        model.addAttribute("check",check);
        model.addAttribute("review",review);
        return "delivery";
    }

    @PostMapping("/orderInfo")
    public String orderInfo(){
        return "order_info";
    }




}
