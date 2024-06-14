package collection.list;

import java.util.ArrayList;
import java.util.List;

public class List_1 {
    public static void main(String[] args) {
        //ArrayList 리스트 자료구조 클래스화
        //수많은 데이터를 저장하는 공간
        //String 데이터를 다 수 저장하기 위한 List(통) 생성
        //기본자료형은 사용못한다 -> wrapper 클래스 사용
        //List : 순번 존재 , 중복 가능
//        ArrayList<String> list1 = new ArrayList<>();
        List<String> list1 = new ArrayList<>();

        //리스트에 데이터 저장하기
        list1.add("java");
        list1.add("c++");
        list1.add("python");
        list1.add("python");
        //리스트에 저장된 데이터 삭제하기
        list1.remove(1);
        //리스트에 저장된 데이터 읽기, 순번으로 접근
        list1.get(1);
        System.out.println(list1.get(1));
        //리스트에 저장된 데이터 수
        System.out.println(list1.size());
        //리스트에 저장된 모든 데이터 출력
        for (int i = 0; i < list1.size(); i++){
            System.out.println(list1.get(i));
        }



        //정수 데이터를 다 수 저장하기 위한 List(통) 생성
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(100);
        list2.add(100);
        list2.add(100);
        list2.add(100);
        System.out.println(list2);
    }
}
