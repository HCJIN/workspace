package com.green.Shop.admin.service;

import com.green.Shop.item.vo.CategoryVO;
import com.green.Shop.item.vo.ItemVO;

import java.util.List;

public interface AdminService {

    //카테고리 목록 조회
    List<CategoryVO> getCateList();

    //상품등록
    void setItem(ItemVO itemVO);
}
