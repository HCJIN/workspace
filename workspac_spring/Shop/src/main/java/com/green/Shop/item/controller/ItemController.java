package com.green.Shop.item.controller;

import com.green.Shop.item.service.ItemService;
import com.green.Shop.item.vo.CartVO;
import com.green.Shop.item.vo.ItemVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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

    //아이템 상세정보 조회
    @GetMapping("/getItem/{itemCode}")
    public ItemVO getItem(@PathVariable("itemCode")int itemCode){
        return itemService.getItem(itemCode);
    }

    //카트등록
    @PostMapping("/insertCart")
    public void insertCart(@RequestBody CartVO cartVO){
        System.out.println(cartVO);
        itemService.insertCart(cartVO);
    }

    //장바구니리스트 조회
    @GetMapping("/getCartList/{memId}")
    public List<CartVO> getCartList(@PathVariable("memId")String memId){
        return itemService.getCartList(memId);
    }

}
