package com.green.Shop.item.service;

import com.green.Shop.item.vo.CartVO;
import com.green.Shop.item.vo.ItemVO;

import java.util.List;

public interface ItemService {

    //아이템 리스트 조회
    List<ItemVO> getItemList();

    //아이템 상세정보 조회
    ItemVO getItem(int itemCode);

    //장바구니 등록
    void insertCart(CartVO cartVO);

    //장바구니 리스트 조회
    List<CartVO> getCartList(String memId);
}
