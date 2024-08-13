package com.green.Shop.item.vo;

import com.green.Shop.member.vo.MemberVO;
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
