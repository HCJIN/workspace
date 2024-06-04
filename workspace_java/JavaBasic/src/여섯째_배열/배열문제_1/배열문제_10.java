package 여섯째_배열.배열문제_1;

import java.util.Arrays;
import java.util.Scanner;

public class 배열문제_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("값을 입력하시오 : ");

        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++){
            int num = sc.nextInt();
            arr[i] = num;
        }
        System.out.println(Arrays.toString(arr));

    }
}
