package 다섯째_반복문.While.반복문_2;

import java.util.Scanner;

public class 반복문_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("두 수를 입력하시오 : ");
        int k = sc.nextInt();
        int j = sc.nextInt();

        int sum = 0;

        for ( int i = k; i <= j; i++){
            sum = sum + i;
        }
        System.out.println(sum);

    }
}
