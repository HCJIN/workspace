package com.green.ListPractice.controller;

import com.green.ListPractice.vo.Board2VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController2 {

    //게시글 목록을 저장하고 있을 리스트
    List<Board2VO> boardList = new ArrayList<>();


    @GetMapping("/list2")
    public String boardList(Model model){
        //게시글 목록 데이터를 html 로 전달
        model.addAttribute("boardList", boardList);

        return "board_list2";
    }

    @GetMapping("/writeForm2")
    public String writeForm2(){
        return "board_write_form2";
    }

    @PostMapping("/regBoard2")
    public String regBoard(Board2VO board2VO){
        System.out.println(board2VO);
        boardList.add(board2VO);
        return "redirect:/list2";
    }

    @GetMapping("/detail2")
    public String detail(@RequestParam(name="boardNum") int boardNum,Model model){
        Board2VO result = null;
        for (Board2VO board : boardList){
            if (board.getBoardNum() == boardNum){
                result = board;
            }
        }
        System.out.println(result);
        model.addAttribute("boardList",result);

        return "board_detail2";
    }

    @GetMapping("/delete2")
    public String delete2(@RequestParam(name="boardNum") int boardNum){
        int index = 0;
        for (int i = 0; i < boardList.size(); i++){
            if (boardList.get(i).getBoardNum() == boardNum){
                index = i;
            }
        }

        boardList.remove(index);

        return "redirect:/list2";


    }
}
