package com.green.ReactItem.service;

import com.green.ReactItem.vo.ItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemListService")
public class ItemListServiceImpl implements ItemListService{

    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public List<ItemVO> getItemList() {
        return sqlSession.selectList("itemMapper.getItemList");
    }

    @Override
    public ItemVO detail(int itemNum) {
        return sqlSession.selectOne("itemMapper.detail",itemNum);
    }

    @Override
    public void update(ItemVO itemVO) {
        sqlSession.update("itemMapper.update",itemVO);
    }

    @Override
    public void insert(ItemVO itemVO) {
        sqlSession.insert("itemMapper.insert",itemVO);
    }
}
