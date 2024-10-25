package basic;

//좋은 코딩은 컴파일 오류가 많이 나는 코드다.
//컴파일 오류 : 코드를 실행하기 전에 발생하는 오류, 빨간줄로 표시 됨
//런타임 오류 : 코드를 실행하면 발생하는 오류, 빨간색 표시x, 찾기 어려움

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Generic을 사용하지 않았을 때 단점
// 1. 데이터를 리턴받을 때 매번 형변환 작업 진행
// 2. 개발자의 실수로 발생하는 런타임 오류를 작성할 확률이 높다
public class BeforeBoxTest {
    public static void main(String[] args) {
        //BeforeBox 객체 생성
//        BeforeBox box1 = new BeforeBox();
//        box1.setData("apple");
//
//        BeforeBox box2 = new BeforeBox();
//        box2.setData(5);
//
//        BeforeBox box3 = new BeforeBox();
//        box3.setData(new Apple());
//
//        BeforeBox box4 = new BeforeBox();
//        box4.setData(new Orange());
//
//        //box1에 저장된 데이터를 받아오기
//        String data1 = (String)box1.getData();
//        int data2 = (int)box2.getData();
//        Apple data3 =  (Apple)box3.getData();
//
//        Orange data4 =  (Orange)box3.getData();
//
//        System.out.println("data1 = " + data1);
//        System.out.println("data2 = " + data2);
//        System.out.println("data3 = " + data3);

        String ss = "aa  bb cc";
        String answer = "";
        String[] arr = ss.split(" ");


        List<String> list = new ArrayList<>();

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i].equals(""))
                list.add(" ");
            else{
                list.add(arr[i].substring(0,1).toUpperCase() + arr[i].substring(1, arr[i].length()).toLowerCase());
            }
        }

        for(String str : list){
            answer = answer + str + "_";
        }


        //"aa bb cc "
        //"abc "
        answer = answer.substring(0, answer.length() - 1);
        System.out.println(answer);
        System.out.println(answer.length());


    }
}
