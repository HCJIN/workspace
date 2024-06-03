package 네번째_조건문;

import java.util.Scanner;

public class Switch_예제_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력 하시오 : ");

        int num = sc.nextInt();
        int con = num % 2;

        switch (con){
            case 0 :
                System.out.println(1);
                break;
            case 1 :
                System.out.println(2);
                break;
            default:
                System.out.println(0);
        }







    }
}
