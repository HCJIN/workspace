package com.green.BasicBoard.service;

import com.green.BasicBoard.vo.BoardVO;
import com.green.BasicBoard.vo.SearchVO;

import java.util.List;

public interface BoardService {

    List<BoardVO> select(SearchVO searchVO);

    void insert(BoardVO boardVO);

    BoardVO detail(int boardNum);

    void update(BoardVO boardVO);

    void delete(int boardNum);

    void update2(int boardNum);

}
