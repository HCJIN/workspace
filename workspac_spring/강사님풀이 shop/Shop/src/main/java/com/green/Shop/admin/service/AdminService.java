package com.green.Shop.admin.service;

import com.green.Shop.item.vo.CategoryVO;
import com.green.Shop.item.vo.ItemVO;

import java.util.List;

public interface AdminService {

    //카테고리 리스트 조회
    List<CategoryVO> getItemCategory();

    //아이템 리스트 조회
    List<ItemVO> getItemList();

    //상품등록
    void setItem(ItemVO itemVO);
}
