package com.green.DB_Score.service;

import com.green.DB_Score.vo.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public List<BoardVO> select() {
        List<BoardVO> list = sqlSession.selectList("boardMapper.select");
        return list;
    }

    @Override
    public void insert(BoardVO boardVO) {
        sqlSession.insert("boardMapper.insert",boardVO);
    }

    @Override
    public BoardVO detail(int boardNum) {
        BoardVO board = sqlSession.selectOne("boardMapper.detail",boardNum);
        return board;
    }

    @Override
    public void delete(int boardNum) {
        sqlSession.delete("boardMapper.delete",boardNum);
    }

    @Override
    public void update(BoardVO boardVO) {
        sqlSession.update("boardMapper.update",boardVO);
    }

    @Override
    public void readUpdate(int boardNum) {
        sqlSession.update("boardMapper.readUpdate",boardNum);
    }


}
