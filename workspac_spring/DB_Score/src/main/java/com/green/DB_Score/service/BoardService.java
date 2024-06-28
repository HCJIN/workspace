package com.green.DB_Score.service;

import com.green.DB_Score.vo.BoardVO;

import java.util.List;

public interface BoardService {

    List<BoardVO> select();

    void insert(BoardVO boardVO);

    BoardVO detail(int boardNum);

    void delete(int boardNum);

    void update(BoardVO boardVO);

    void readUpdate(int boardNum);
}
