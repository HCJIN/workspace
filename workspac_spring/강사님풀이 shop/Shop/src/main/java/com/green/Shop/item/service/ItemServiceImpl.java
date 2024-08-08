package com.green.Shop.item.service;

import com.green.Shop.item.vo.ItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService{

    @Autowired
    private SqlSessionTemplate sqlSession;

    //아이템 리스트 조회
    @Override
    public List<ItemVO> getItemList() {
        return sqlSession.selectList("itemMapper.getItemList");
    }

    @Override
    public List<ItemVO> aaa() {
        return sqlSession.selectList("itemMapper.aaa");
    }

}
