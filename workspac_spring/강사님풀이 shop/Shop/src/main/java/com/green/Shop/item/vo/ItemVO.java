package com.green.Shop.item.vo;


import lombok.Data;

import java.util.List;

@Data
public class ItemVO {
    private int itemCode;
    private String itemName;
    private int itemPrice;
    private String itemIntro;
    private int itemStock;
    private String itemStatus;
    private int cateCode;
//    private String attachedFileName;
    private List<ImgVO> imgList;
}
