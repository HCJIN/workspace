package com.green.ReactBoard.service;

import com.green.ReactBoard.vo.BoardVO;

import java.util.List;

public interface BoardService {

    //게시글 목록 조회
    List<BoardVO> getBoardList();

    //상세보기
    BoardVO getBoard(int boardNum);

    //글등록
    void inBoard( BoardVO boardVO);

}
