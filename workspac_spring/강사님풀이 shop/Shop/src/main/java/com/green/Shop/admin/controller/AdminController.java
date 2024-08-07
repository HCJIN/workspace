package com.green.Shop.admin.controller;

import com.green.Shop.admin.service.AdminService;
import com.green.Shop.item.vo.CategoryVO;
import com.green.Shop.item.vo.ItemVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource(name = "adminService")
    private AdminService adminService;

    @GetMapping("/itemList")
    public List<CategoryVO> getItemCategory(){
        return adminService.getItemCategory();
    }

    //아이템 등록
    @PostMapping("/setItem")
    public void setItem(@RequestBody ItemVO itemVO){
        System.out.println(itemVO);
        adminService.setItem(itemVO);
    }

    //아이템 리스트 조회
    @GetMapping("/getItemList")
    public List<ItemVO> getitemList(){
        return adminService.getItemList();
    }

}
