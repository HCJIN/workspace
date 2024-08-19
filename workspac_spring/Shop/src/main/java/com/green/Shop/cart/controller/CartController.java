package com.green.Shop.cart.controller;


import com.green.Shop.cart.service.CartService;
import com.green.Shop.cart.vo.CartVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Resource(name ="cartService")
    private CartService cartService;

    //카트등록
    @PostMapping("/insertCart")
    public void insertCart(@RequestBody CartVO cartVO){
        System.out.println(cartVO);
        cartService.insertCart(cartVO);
    }

    //장바구니리스트 조회
    @GetMapping("/getCartList/{memId}")
    public List<CartVO> getCartList(@PathVariable("memId")String memId){
        return cartService.getCartList(memId);
    }

    //장바구니 가격 업데이트
    @PostMapping("/updateCart")
    public void updateCart(@RequestBody CartVO cartVO){
        System.out.println(cartVO);
        cartService.updateCart(cartVO);
    }

    //장바구니 목록 삭제
    @DeleteMapping("/cartDelete/{cartCode}")
    public void cartDelete(@PathVariable("cartCode")int cartCode){
        cartService.cartDelete(cartCode);
    }

    //장바구니 중복 확인 true 면 중복이 없고 false 면 중복이 있음
    @GetMapping("/cartChk/{attachedFileName}")
    public boolean cartChk(@PathVariable("attachedFileName")String attachedFileName){
        return cartService.cartChk(attachedFileName);
    }
}
