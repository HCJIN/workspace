package 여섯째_배열.집에서;

import java.util.Arrays;

public class 문제2_8 {
    public static void main(String[] args) {


        int[] arr = new int[6];

        for (int i = 0; i < arr.length; i++){
            int a = (int)(Math.random() * 44 + 1) + 1;
            arr[i] = a;
        }
        System.out.println(Arrays.toString(arr));
    }
}
