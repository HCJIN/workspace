package 다섯째_반복문.While.반복문_1;

import java.util.Scanner;

public class While문제16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("임의의 정수를 입력하시오 : ");
        int i = sc.nextInt();
        int sum = 0;

        for (int j = 1; j <= i; j++){
            if (j % 2 == 0){
                sum++;
            }
        }
        System.out.println("입력받은 짝수의 개수 : " + sum);

    }
}
