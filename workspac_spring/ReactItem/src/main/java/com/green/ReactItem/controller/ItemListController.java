package com.green.ReactItem.controller;

import com.green.ReactItem.service.ItemListService;
import com.green.ReactItem.vo.ItemVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemListController {

    @Resource(name = "itemListService")
    private ItemListService itemList;

    //목록 조회
    @GetMapping("/getMain")
    public List<ItemVO> itemList(){
        System.out.println(itemList.getItemList());
        return itemList.getItemList();
    }

    //상세 조회
    @GetMapping("/detail/{itemNum}")
    public ItemVO detail(@PathVariable("itemNum")int iteNum){
        return itemList.detail(iteNum);
    }

    //정보 수정
    @PostMapping("/update/{itemNum}")
    public void update(@RequestBody ItemVO itemVO){
        System.out.println(itemVO);
        itemList.update(itemVO);
    }

    //상품 등록
    @GetMapping("/insert")
    public void insert(){
        
    }



}
