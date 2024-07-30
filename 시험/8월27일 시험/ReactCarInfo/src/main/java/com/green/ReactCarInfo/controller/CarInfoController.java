package com.green.ReactCarInfo.controller;

import com.green.ReactCarInfo.sevice.CarInfoService;
import com.green.ReactCarInfo.vo.CarInfoVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
public class CarInfoController {

    @Resource(name = "carInfoService")
    private CarInfoService carInfoService;

    /* 리스트 조회 */
    @GetMapping("/carList")
    public List<CarInfoVO> carList(){
        return carInfoService.getCarList();
    }

    /* 데이터 삽입 */
    @PostMapping("/insert")
    public void insert(@RequestBody CarInfoVO carInfoVO){
        System.out.println(carInfoVO);
        carInfoService.insert(carInfoVO);
    }
}
