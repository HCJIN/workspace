package com.green.Shop.admin.controller;

import com.green.Shop.admin.service.AdminService;
import com.green.Shop.item.vo.CategoryVO;
import com.green.Shop.item.vo.ImgVO;
import com.green.Shop.item.vo.ItemVO;
import com.green.Shop.util.FileUploadUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    //첨부파일이 포함된 데이터가 전달되면 자바에서 데이터를 받는 문법도 달라진다.
    //첨부파일이 함께 전달되면 @RequestBody 어노테이션을 작성하지 않는다.
    @PostMapping("/setItem")
    public void setItem(ItemVO itemVO
            ,@RequestParam("mainImg") MultipartFile mainImg
            ,@RequestParam("subImg") MultipartFile subImg){

        //---- 파일 업로드 ----
        //메인이 되는 이미지 첨부 후 첨부된 원본 파일명, 첨부된 파일명을 리턴 받음
        ImgVO mainimgVO = FileUploadUtil.fileUpload(mainImg);
        mainimgVO.setIsMain("Y");

        //서브가 되는 이미지 첨부 후 첨부된 원본 파일명, 첨부된 파일명을 리턴 받음
        ImgVO subImgVO = FileUploadUtil.fileUpload(subImg);
        subImgVO.setIsMain("N");

        //등록한 상품의 item_code 조회
        int nextItemCode = adminService.getNextItemCode();

        //itemVO에 조회한 item_code 저장
        itemVO.setItemCode(nextItemCode);

        //상품 정보 등록
        adminService.setItem(itemVO);

        //itemVO 객체에 이미지 정보를 다 저장
        //1. imgVO를 여러개 저장할 수 있는 List 생성
        List<ImgVO> imgList = new ArrayList<>();

        //2. imgList 에 첨부된 이미지 정보 저장
        imgList.add(mainimgVO);
        imgList.add(subImgVO);

        //3. itemVO 에 imgList 저장
        itemVO.setImgList(imgList);

        //상품 이미지 정보 등록
        adminService.insertImgs(itemVO);
    }

}
