package com.green.Shop.admin.service;

import com.green.Shop.item.vo.CategoryVO;
import com.green.Shop.item.vo.ItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private SqlSessionTemplate sqlSession;


    //카테고리 조회
    @Override
    public List<CategoryVO> getCateList() {
        return sqlSession.selectList("adminMapper.getCategoryList");
    }

    //아이템 등록
    @Override
    public void insertItem(ItemVO itemVO) {
        sqlSession.insert("adminMapper.insertItem",itemVO);
    }

    //상품 이미지 등록
    @Override
    public void insertImgs(ItemVO itemVO) {
        sqlSession.insert("adminMapper.insertImgs",itemVO);
    }

    //다음에 들어갈 item_code 조회
    @Override
    public int getNextItemCode() {
        return sqlSession.selectOne("adminMapper.getNextItemCode");
    }


}
