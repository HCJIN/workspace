package com.green.AxiosTest.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AxiosVO {
    private int itemNum ;
    private String itemName;
    private  int price;
    private  String intro;
    private String imgName;

    public AxiosVO(int itemNum, String itemName, int price, String intro, String imgName) {
        this.itemNum = itemNum;
        this.itemName = itemName;
        this.price = price;
        this.intro = intro;
        this.imgName = imgName;
    }

}
