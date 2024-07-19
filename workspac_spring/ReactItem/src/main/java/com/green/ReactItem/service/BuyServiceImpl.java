package com.green.ReactItem.service;


import com.green.ReactItem.vo.BuyVO;
import com.green.ReactItem.vo.ItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("buyService")
public class BuyServiceImpl implements BuyService{

    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public List<ItemVO> order() {
        return sqlSession.selectList("buyMapper.order");
    }
}
