package 세번째_연산자;

/*
    키보드로 이름, 국어점수, 영어점수, 수학점수를 입력받는다.
    단, 점수들은 정수만 입력한다고 가정한다.

    모든 정보를 입력받은 후
    입력받은 이름, 국어점수, 영어점수, 수학점수와 총점 및 평균을 출력
*/

import java.util.Scanner;

public class 연습문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("이름, 국어점수, 영어점수, 수학점수를 입력하시오.");
        System.out.print("이름 : ");
        // 키보드로 이름 입력
        String name = sc.next();
        // 키보드로 국어점수 입력
        System.out.print("국어점수 : ");
        int point1 = sc.nextInt();
        // 키보드로 영어점수 입력
        System.out.print("영어점수 : ");
        int point2 = sc.nextInt();
        // 키보드로 수학점수 입력
        System.out.print("수학점수 : ");
        int point3 = sc.nextInt();

        int sum = point1 + point2 + point3;
        double aver = sum / 3.0;

        System.out.println(" 이름은 : " + name);
        System.out.println(" 총점은 : " + sum);
        System.out.println(" 평균은 : " + aver);


    }
}
