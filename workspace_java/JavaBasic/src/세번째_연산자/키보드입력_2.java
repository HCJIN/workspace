package 세번째_연산자;

import java.util.Scanner;

public class 키보드입력_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //키보드로 문자열 하나를 입력
       String r1= sc.next();

       //키보드로 실수 하나를 입력
       double r2 = sc.nextDouble();

        System.out.println("입력 받은 글 : " + r1);
        System.out.println("입력 받은 실수 : " + r2);



    }
}
