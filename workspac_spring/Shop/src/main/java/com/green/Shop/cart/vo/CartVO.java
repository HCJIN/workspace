package com.green.Shop.cart.vo;

import com.green.Shop.item.vo.ImgVO;
import com.green.Shop.item.vo.ItemVO;
import lombok.Data;

import java.util.List;

@Data
public class CartVO {
    private int cartCode;
    private int cartCnt;
    private String cartDate;
    private int itemCode;
    private String memId;
    private List<ImgVO> imgList;
    private ItemVO item;
}
