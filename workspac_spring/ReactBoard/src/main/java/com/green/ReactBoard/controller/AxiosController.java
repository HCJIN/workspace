package com.green.ReactBoard.controller;

import com.green.ReactBoard.service.AxiosServiceImpl;
import com.green.ReactBoard.vo.BoardVO;
import com.green.ReactBoard.vo.MemberVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AxiosController {

    @Resource(name = "axiosService")
    private AxiosServiceImpl axiosService;

    //1번 버튼 클릭 시 호출되는 메소드
    @GetMapping("/getList")
    public List<BoardVO> getList(){
        return axiosService.getList();
    }

    @PostMapping("/insertBoard")
    public void insertBoard(@RequestBody MemberVO memberVO){
        System.out.println(1);
        System.out.println(memberVO);
    }

    @PutMapping("/updateBoard")
    public int updateBoard(@RequestBody BoardVO boardVO){
        System.out.println(boardVO);

        return 10;
    }

//    @GetMapping("/detail/{boardNum}")
//    public void detail(@PathVariable("boardNum")int boardNum){
//        System.out.println(boardNum);
//    }




}
