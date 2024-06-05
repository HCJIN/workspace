package 여섯째_배열.배열문제_1;

import java.util.Arrays;
import java.util.Scanner;

public class 배열문제_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++){
            System.out.print(i + "번째 요소 입력 : ");
            arr[i] = sc.nextInt();
        }
        System.out.println("-배열에 저장된 요소-");
        for (int e : arr){
            System.out.print(e + " ");
        }


        System.out.println(Arrays.toString(arr));

    }
}
