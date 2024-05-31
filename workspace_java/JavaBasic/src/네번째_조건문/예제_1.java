package 네번째_조건문;

import java.util.Scanner;

public class 예제_1 {
    public static void main(String[] args) {
        //키보드로 정수를 입력받아
        Scanner sc = new Scanner(System.in);

        System.out.print("값을 입력 해주세요 : ");
        int num = sc.nextInt();

        if(num > 10){
            System.out.println("10보다 큽니다");
        }

    }
}
