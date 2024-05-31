package 네번째_조건문;

import java.util.Scanner;

public class 예제_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        int num = sc.nextInt();

        if(num % 2 == 0){
            System.out.println(1);
        }else{
            System.out.println(2);
        }
    }
}
