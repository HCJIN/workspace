package com.green.Shop.item.controller;

import com.green.Shop.item.service.ItemService;
import com.green.Shop.item.vo.ItemVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Resource(name = "itemService")
    private ItemService itemService;

    //아이템 리스트 조회
    @GetMapping("/getItemList")
    public List<ItemVO> getitemList(){
        return itemService.getItemList();
    }

    @GetMapping("/aaa")
    public List<ItemVO> aaa(){
        return itemService.aaa();
    }

}
