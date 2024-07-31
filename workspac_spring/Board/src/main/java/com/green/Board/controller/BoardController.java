package com.green.Board.controller;

import com.green.Board.service.BoardService;
import com.green.Board.service.BoardServiceImpl;
import com.green.Board.vo.BoardVO;
import com.green.Board.vo.PageVO;
import com.green.Board.vo.SearchVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")
@Slf4j
public class BoardController {

    @Resource(name = "boardService")
    private BoardService boardService;

    //게시글 목록
    @GetMapping("/list")
    public String getBoardList(){
        return "게시글 목록";
    }

    //게시글 목록 조회
    @PostMapping("/boardList")
    public Map<String, Object> boardList(@RequestBody(required = false) SearchVO searchVO){
        log.info("====" + searchVO.getPageNo());

        //전체 게시글 수
        int totalDataCnt = boardService.getBoardCnt();

        //페이지 정보를 담을 수 있는 PageVO 객체 생성
        PageVO pageInfo = new PageVO(totalDataCnt);

        pageInfo.setNowPage(searchVO.getPageNo());

        pageInfo.setPageInfo();

        System.out.println(pageInfo);

        //게시글 목록 데이터
        List<BoardVO> boardList = boardService.getBoardList(pageInfo);

        //리액트로 가져갈 모든 데이터를 담을 변수
        Map<String, Object> mapData = new HashMap<>();
        //페이징 정보가 담긴 데이터
        mapData.put("pageInfo", pageInfo);
        mapData.put("boardList", boardList);

        return mapData;
    }

    //게시글 등록
    @PostMapping("/inBoard")
    public void inBoard(@RequestBody BoardVO boardVO){
        System.out.println(boardVO);
        boardService.inBoard(boardVO);
    }

    //디테일 조회
    @GetMapping("/detail/{boardNum}")
    public BoardVO detail(@PathVariable("boardNum")int boardNum){
        return boardService.getBoard(boardNum);
    }

    //게시글 수정
    @PostMapping("/update/{boardNum}")
    public void update(@RequestBody BoardVO boardVO){
        boardService.update(boardVO);
    }

    //게시글 삭제
    @DeleteMapping("/delete/{boardNum}")
    public void delete(@PathVariable("boardNum")int boardNum){
        boardService.delete(boardNum);
    }


}
