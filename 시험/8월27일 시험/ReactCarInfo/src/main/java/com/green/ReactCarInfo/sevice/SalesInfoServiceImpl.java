package com.green.ReactCarInfo.sevice;

import com.green.ReactCarInfo.vo.SalesVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("salesInfoService")
public class SalesInfoServiceImpl implements SalesInfoService{

    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public List<SalesVO> getSalesList() {
        return sqlSession.selectList("salesMapper.getSalesList");
    }

    @Override
    public void inBuyer(SalesVO salesVO) {
        sqlSession.insert("salesMapper.inBuyer",salesVO);
    }
}
