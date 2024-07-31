package com.green.Board.service;

import com.green.Board.vo.BoardVO;
import com.green.Board.vo.MemberVO;
import com.green.Board.vo.PageVO;
import com.green.Board.vo.SearchVO;

import java.util.List;

public interface BoardService {

    List<BoardVO> getBoardList(PageVO pageVO);

    BoardVO getBoard(int boardNum);

    void inBoard(BoardVO boardVO);

    void update(BoardVO boardVO);

    void delete(int boardNum);

    //전체 게시글 갯수 조회
    int getBoardCnt();

}
