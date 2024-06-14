package collection.list문제.list문제1;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {

        //문제 1번
//        List<String> test1 = new ArrayList<>();
//        test1.add("집");
//        test1.add("가");
//        test1.add("자");
//        for (int i = 0; i < test1.size(); i++){
//            System.out.println(test1.get(i));
//        }
//        System.out.println(test1);

        //문제2번
//        List<Integer> test2 = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        int sum = 0;
//        for (int i = 0; i < 5; i++)
//            System.out.print("정수 5개를 입력 하시오 : ");
//            test2.add(sc.nextInt());
//            sum = sum + test2.get(i);
//        }
//        System.out.println(sum);

        //문제3번
//        List<String> test3 = new ArrayList<>();
//        test3.add("홍");
//        test3.add("길");
//        test3.add("동");
//        test3.add("홍길동");
//        for (int i = 0; i < test3.size(); i++){
//            if (test3.get(i).equals("홍길동")){
//                System.out.println("해당 이름이 존재합니다.");
//            }else{
//            }
//        }
//        System.out.println("해당 이름이 존재하지 않습니다.");

        //문제4번
        List<Integer> test4 = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < 10; i++){
            int rand = (int)(Math.random()*100-1+1)+1;
            test4.add(rand);
            if (test4.get(i) % 2 ==0){
                cnt++;
                System.out.println(test4.get(i));
            }
        }
        System.out.println("짝수 개수 : " + cnt);
        //문제5번


    }
}
