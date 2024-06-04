package 다섯째_반복문.While.반복문_2;

import java.util.Scanner;

public class 반복문_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫번째 수를 입력하시오 : ");
        int num1 = sc.nextInt();
        System.out.print("두번째 수를 입력하시오 : ");
        int num2 = sc.nextInt();

        //큰수, 작은수 결정
        int max, min;

        if(num1 > num2){
            max = num1;
            min = num2;
        }else{
            max = num2;
            min = num1;
        }

        int sum = 0;

        for (int i = min+1; i < max; i++){
            sum = sum + i;
        }
        System.out.println(sum);

    }
}
