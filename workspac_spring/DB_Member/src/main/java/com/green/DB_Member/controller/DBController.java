package com.green.DB_Member.controller;

import com.green.DB_Member.service.DBServiceImpl;
import com.green.DB_Member.vo.MemberVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DBController {

    @Resource(name = "dbService")
    private DBServiceImpl dbService;

    //회원번호가 1번인 회원의 이름을 조회
    @GetMapping("/select1")
    public String select1(){

        String name = dbService.select1();
        System.out.println("조회한 이름 : " + name );

        return "db_result";
    }

    //전달된 회원번호를 지닌 회원의 나이를 조회
    @GetMapping("/select2")
    public String select2(){
        int age = dbService.select2(3);
        System.out.println("전달된 회원번호를 지닌 회원 나이 : " + age);
        return "db_result";
    }

    //전달받은 나이 이상의 회원의 이름을 조회
    @GetMapping("/select3")
    public String select3(){
        List<String> nameList = dbService.select3(40);
        for (String name : nameList){
            System.out.println("조회된 이름 : " + name);
        }
        return "db_result";
    }

    //전달받은 회원번호를 지닌 회원의 회원번호, 이름, 나이, 주소를 조회
    @GetMapping("/select4")
    public String select4(){
        MemberVO memberVO = dbService.select4(4);
        System.out.println(memberVO);
        System.out.println("조회된 회원번호 : " + memberVO.getMemNum());
        System.out.println("조회된 이름 : " + memberVO.getMenName());
        System.out.println("조회된 나이 : " + memberVO.getMemAge());
        System.out.println("조회된 주소 : " + memberVO.getMenAddr());
        return "db_result";
    }

    //모든 회원의 회원번호, 이름, 나이, 주소 조회
    @GetMapping("/select5")
    public String select5(){
        List<MemberVO> memberVO = dbService.select5();
        for (MemberVO member  : memberVO){
            System.out.println(member);
        }
        return "db_result";
    }

    //전달받은 회원번호를 가진 회원을 삭제
    @GetMapping("/delete")
    public String delete(){
        int num = dbService.delete(4);
        System.out.println("삭제되는 행 개수 : " + num);
        return "db_result";
    }

    @GetMapping("/insert")
    public String insert(){

        MemberVO memberVO = new MemberVO();
        memberVO.setMemNum(3);
        memberVO.setMenName("홍길동3");
        memberVO.setMemAge(16);
        memberVO.setMenAddr("서귀포시");

        dbService.insert(memberVO);

        return "db_result";
    }

    //전달받은 회원번호를 지닌 회원의 이름, 나이, 주소를 변경
    @GetMapping("/update")
    public String update(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemNum(3);
        memberVO.setMenName("홍길동삼");
        memberVO.setMemAge(19);
        memberVO.setMenAddr("제주시");

        int num = dbService.update(memberVO);
        System.out.println(num);

        return "db_result";
    }




}
