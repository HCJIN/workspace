package 여섯째_배열.배열문제_2;

import java.util.Arrays;
import java.util.Scanner;

public class 배열문제_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력 해주세요 : ");

        int num = sc.nextInt();

        int[] arr = new int[num];

        int avg = 0;

        for (int i = 0; i < arr.length; i++ ) {
            arr[i] = i + 1;
            avg = avg + i + 1;
        }
        System.out.println(avg / (double)num);

        System.out.println("---------------강사님 풀이----------------");

        System.out.print("배열의 크기 : ");
        int length = sc.nextInt();

        int[] arr2 = new int[length];

        for (int i = 0; i < arr2.length; i++){
            arr2[i] = i + 1;
        }

        int sum = 0;
        for (int e : arr2){
            sum = sum + e;
        }
        System.out.println(sum / (double)length);





    }
}
