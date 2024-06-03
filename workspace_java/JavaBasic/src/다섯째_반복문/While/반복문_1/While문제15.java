package 다섯째_반복문.While.반복문_1;

import java.util.Scanner;

public class While문제15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("임의의 정수를 입력하시오 : ");
        int i = sc.nextInt();
        int j = 1;
        int sum = 0;

        while (j <= i){
            if (j % 2 == 0){
                sum++;
            }
            j++;
        }
        System.out.println("짝수의 개수 : " + sum);

    }
}
