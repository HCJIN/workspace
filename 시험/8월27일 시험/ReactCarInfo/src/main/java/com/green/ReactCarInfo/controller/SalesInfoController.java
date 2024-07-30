package com.green.ReactCarInfo.controller;

import com.green.ReactCarInfo.sevice.SalesInfoService;
import com.green.ReactCarInfo.vo.SalesVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesInfoController {

    @Resource(name = "salesInfoService")
    private SalesInfoService salesInfoService;

    @GetMapping("/salesList")
    public List<SalesVO> salesList(){
        return salesInfoService.getSalesList();
    }

    @PostMapping("/inBuyer")
    public void inBuyer(@RequestBody SalesVO salesVO){
        System.out.println(salesVO);
        salesInfoService.inBuyer(salesVO);
    }
}
