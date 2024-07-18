package com.green.ReactItem.service;

import com.green.ReactItem.vo.ItemVO;

import java.util.List;

public interface ItemListService {

    List<ItemVO> getItemList();

    ItemVO detail(int itemNum);

    void update(ItemVO itemVO);


}
