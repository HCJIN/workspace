package 네번째_조건문;

import java.util.Scanner;

public class Switch_예제_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("점수를 입력 하시오 : ");
        int x = sc.nextInt();

        switch (x/10){
            case 10, 9:
                System.out.println("A");
            //8 ...
            //7 ...
            //6 ...
        }

    }
}









