package com.green.ReactCarInfo.sevice;

import com.green.ReactCarInfo.vo.CarInfoVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carInfoService")
public class CarInfoServiceImpl implements CarInfoService{

    @Autowired
    private SqlSessionTemplate sqlSession;

    /* 리스트 조회 */
    @Override
    public List<CarInfoVO> getCarList() {
        return sqlSession.selectList("carMapper.getCarList");
    }

    /* 데이터 삽입 */
    @Override
    public void insert(CarInfoVO carInfoVO) {
        sqlSession.insert("carMapper.insert",carInfoVO);
    }
}
