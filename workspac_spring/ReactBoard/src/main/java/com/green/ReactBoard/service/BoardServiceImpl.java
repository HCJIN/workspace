package com.green.ReactBoard.service;

import com.green.ReactBoard.vo.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

    @Autowired
    private SqlSessionTemplate sqlSession;


    //게시글 목록 조회
    @Override
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = sqlSession.selectList("boardMapper.getBoardList");
        return boardList;
    }
}
