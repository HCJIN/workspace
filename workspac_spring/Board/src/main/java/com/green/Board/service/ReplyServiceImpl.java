package com.green.Board.service;

import com.green.Board.vo.ReplyVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService{

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<ReplyVO> getReplyList(int boardNum) {
        return sqlSession.selectList("replyMapper.getReplyList",boardNum);
    }

    @Override
    public void insert(ReplyVO replyVO) {
        sqlSession.insert("replyMapper.insert",replyVO);
    }

    @Override
    public void delete(int replyNum) {
        sqlSession.delete("replyMapper.delete",replyNum);
    }
}
