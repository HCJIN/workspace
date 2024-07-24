package com.green.Board.service;

import com.green.Board.vo.BoardVO;
import com.green.Board.vo.MemberVO;

import java.util.List;

public interface BoardService {

    List<BoardVO> getBoardList();

    BoardVO getBoard(int boardNum);

    void inBoard(BoardVO boardVO);

}
