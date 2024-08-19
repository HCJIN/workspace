package com.green.Shop.cart.service;

import com.green.Shop.cart.vo.CartVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cartService")
public class CartServiceImpl implements CartService {

    @Autowired
    private SqlSessionTemplate sqlSession;

    //카트 등록
    @Override
    public void insertCart(CartVO cartVO) {
        sqlSession.insert("cartMapper.insertCart", cartVO);
    }

    //장바구니 조회
    @Override
    public List<CartVO> getCartList(String memId) {
        return sqlSession.selectList("cartMapper.getCartList",memId);
    }

    //장바구니 가격 수정
    @Override
    public void updateCart(CartVO cartVO) {
        sqlSession.update("cartMapper.updateCart",cartVO);
    }

    @Override
    public void cartDelete(int cartCode) {
        sqlSession.delete("cartMapper.cartDelete", cartCode);
    }

    //장바구니 중복 데이터 확인
    @Override
    public boolean cartChk(String attachedFileName) {
        String attChk = sqlSession.selectOne("cartMapper.cartChk", attachedFileName);
        return  attChk == null;
    }


}
