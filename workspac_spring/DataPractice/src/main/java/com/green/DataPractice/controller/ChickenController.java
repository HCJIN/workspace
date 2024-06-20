package com.green.DataPractice.controller;

import com.green.DataPractice.vo.ChickenVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChickenController {


    //주문정보 페이지 이동
    @GetMapping("/order")
    public String chicken(){
        return "order";
    }

    //배달정보 페이지로 이동
    @PostMapping("/delivery")
    public String delivery(ChickenVO chickenVO){
        System.out.println(chickenVO);
        return "delivery";
    }

    //주문정보 확인 페이지로 이동
    @PostMapping("/orderInfo")
    public String orderInfo(ChickenVO chickenVO, Model model){
        if (chickenVO.getCheck() == null){
            chickenVO.setCheck(new String[0]);
        }
        int sum = chickenVO.getNum() * 10000;
        int sum2 = 0;
        for (String c : chickenVO.getCheck()){
            if (c.equals("양념추가") || c.equals("머스터드추가") || c.equals("콜라추가")){
                sum2 += 1000;
            }
        }

        model.addAttribute("sum",sum+sum2);
        System.out.println(chickenVO);
        return "order_info";
    }




}
