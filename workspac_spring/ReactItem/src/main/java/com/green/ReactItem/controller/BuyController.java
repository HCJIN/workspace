package com.green.ReactItem.controller;


import com.green.ReactItem.service.BuyService;
import com.green.ReactItem.vo.BuyVO;
import com.green.ReactItem.vo.ItemVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuyController {

    @Resource(name = "buyService")
    private BuyService buyService;

    @GetMapping("/getOrder")
    public List<ItemVO> order(){
        System.out.println(buyService.order());
        return buyService.order();
    }

    @PostMapping("/insert2")
    public void insert(){

    }
}
