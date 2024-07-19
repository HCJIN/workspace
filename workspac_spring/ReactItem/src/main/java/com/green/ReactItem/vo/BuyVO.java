package com.green.ReactItem.vo;


import lombok.Data;

@Data
public class BuyVO {
    private int orderNum;
    private String buyItemName;
    private int buyItemPrice;
    private String buyer;
    private int buyCnt;
    private int buyPrice;
    private String buyDate;
}
