package com.green.Board.service;

import com.green.Board.vo.BoardVO;
import com.green.Board.vo.MemberVO;
import com.green.Board.vo.SearchVO;

import java.util.List;

public interface BoardService {

    List<BoardVO> getBoardList(SearchVO searchVO);

    BoardVO getBoard(int boardNum);

    void inBoard(BoardVO boardVO);

    void update(BoardVO boardVO);

    void delete(int boardNum);

}
