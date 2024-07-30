package com.green.Board.service;

import com.green.Board.vo.ReplyVO;

import java.util.List;

public interface ReplyService {

    //상세보기 댓글 조회
    List<ReplyVO> getReplyList(int boardNum);

    //댓글 등록
    void insert(ReplyVO replyVO);

    //댓글 삭제
    void delete(int replyNum);

    void delete2(int boardNum);
}
