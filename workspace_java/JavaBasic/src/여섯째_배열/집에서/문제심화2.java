package 여섯째_배열.집에서;

import java.util.Arrays;

public class 문제심화2 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int min = 1000;
        int max = 0;
        int num = max;

        for (int i = 0; i < arr.length; i++){
            int a = (int)(Math.random() * 99 + 1) + 1;
            arr[i] = a;
            if (arr[i] > max){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(min);
        System.out.println(max);

    }
}
