package com.green.ReactCarInfo.sevice;

import com.green.ReactCarInfo.vo.SalesVO;

import java.util.List;

public interface SalesInfoService {

    List<SalesVO> getSalesList();

    void inBuyer(SalesVO salesVO);
}
