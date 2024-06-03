package 네번째_조건문;

import java.util.Scanner;

public class Switch_예제_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력 하시오 : ");

        int num = sc.nextInt();

        switch (num){
            case 1 : case 3 : //case 1, 3
                System.out.println("남자");
                break;
            case 2 : case 4 : //case 2, 4
                System.out.println("남자");
                break;
            default:
                System.out.println("오류");

        }

    }
}
