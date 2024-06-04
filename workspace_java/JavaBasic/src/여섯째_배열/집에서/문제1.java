package 여섯째_배열.집에서;

import java.util.Scanner;

public class 문제1 {
    public static void main(String[] args) {

        int[] arr = new int[5];
        System.out.println(arr[2] + arr[4]);
        System.out.println("--------------5번 끝-----------");

        int[] arr2 = new int[10];

        for (int i = 0; i < arr2.length; i++){
            System.out.print(arr2[i]);
        }
        System.out.println();
        System.out.println("--------------6번 끝-----------");

        int[] arr3 = new int[10];

        for (int i = 0; i < arr3.length; i++){
            arr3[i] = 3;
            System.out.print(arr3[i]);
        }
        System.out.println();
        System.out.println("--------------7번 끝-----------");

        int[] arr4 = new int[10];

        for (int i = 0; i < arr4.length; i++){
            arr4[i] = i + 1;
            System.out.print(arr4[i]);
        }
        System.out.println();
        System.out.println("--------------8번 끝-----------");

        int[] arr5 = {1,5,7};
        int sum = 0;

        for (int i = 0; i < arr5.length; i++){
            sum = sum + arr5[i];
        }
        System.out.println(sum);
        System.out.println("--------------9번 끝-----------");

        Scanner sc = new Scanner(System.in);
        System.out.print("정수 5개를 입력해주세요. : ");
        int[] arr6 = new int[5];

        for (int i = 0; i < arr6.length; i++){
            int num = sc.nextInt();
            arr6[i] = num;
            System.out.print(arr6[i]);
        }
        System.out.println();
        System.out.println("--------------10번 끝-----------");

        int[] arr7 = {1,2,3,4,5,6,7,8};
        int cnt = 0;

        for (int i = 0; i < arr7.length; i++){
            if (arr7[i] % 2 == 0){
                cnt++;
            }
        }
        System.out.println("짝수의 개수 : " + cnt);
        System.out.println("--------------11번 끝-----------");

    }
}
