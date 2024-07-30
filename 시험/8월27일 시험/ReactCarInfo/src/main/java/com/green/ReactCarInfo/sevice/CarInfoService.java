package com.green.ReactCarInfo.sevice;

import com.green.ReactCarInfo.vo.CarInfoVO;

import java.util.List;

public interface CarInfoService {

    /* 리스트 조회 */
    List<CarInfoVO> getCarList();

    /* 데이터 삽입 */
    void insert(CarInfoVO carInfoVO);
}
