package 여섯째_배열.집에서;

import java.util.Scanner;

public class 문제2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 하나 입력하시오 : ");
        int num = sc.nextInt();
        int[] arr = new int[num];
        int avg = 0;

        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
            avg = avg + arr[i];
        }
        System.out.println(avg / (double)num);
    }
}
