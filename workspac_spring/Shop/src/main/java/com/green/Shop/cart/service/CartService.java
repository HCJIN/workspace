package com.green.Shop.cart.service;

import com.green.Shop.cart.vo.CartVO;

import java.util.List;

public interface CartService {

    //장바구니 등록
    void insertCart(CartVO cartVO);

    //장바구니 리스트 조회
    List<CartVO> getCartList(String memId);

    //장바구니 가격 수정
    void updateCart(CartVO cartVO);

    //장바구니 목록 삭제
    void cartDelete(int cartCode);

    //장바구니 중복 데이터 확인
    boolean cartChk(String attachedFileName);

}
