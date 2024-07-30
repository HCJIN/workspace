package com.green.ReactCarInfo.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SalesVO {
    private int salesNumber;
    private String buyer;
    private String tel;
    private String color;
    private String salesDate;
    private String modelNum;
    private List<CarInfoVO> carInfo = new ArrayList<>();
}
