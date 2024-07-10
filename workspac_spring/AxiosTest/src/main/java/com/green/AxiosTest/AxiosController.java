package com.green.AxiosTest;

import com.green.AxiosTest.vo.AxiosVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//RestController : 컨트롤러 안의 메소드 리턴이 html 파일명이 아니다!
@RestController
public class AxiosController {

    List<AxiosVO> axiosVOList = new ArrayList<>();

    @GetMapping("/test1")
    public String test1(){
        return "이게 되네";
    }

    @GetMapping("/test2")
    public int test2(){
        return 100;
    }

    @GetMapping("/test3")
    public int[] test3(){
        int[] arr = {1,2,3,4,5};
        return arr;
    }

    @GetMapping("/test4")
    public List<AxiosVO> test4(){
        
        List<AxiosVO> axiosList = new ArrayList<>();

        AxiosVO item = new AxiosVO(1,"처음 만나는 자바",20000,"자바 초보자를 위한 책","book_1.jpg");
        AxiosVO item2 = new AxiosVO(2,"자바 디자인 패턴",25000,"디자인 패턴이 뭔지 알려줌","book_2.jpg");
        AxiosVO item3 = new AxiosVO(3,"모두의 딥러닝",30000,"딥러닝이 뭔지 알려줌","book_3.jpg");

        axiosList.add(item);
        axiosList.add(item2);
        axiosList.add(item3);

        return axiosList;
    }

    @GetMapping("/test5")
    public List<AxiosVO> test5(){

        return axiosVOList;

    }


}
