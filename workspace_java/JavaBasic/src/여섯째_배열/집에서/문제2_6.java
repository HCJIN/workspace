package 여섯째_배열.집에서;

import java.util.Arrays;

public class 문제2_6 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] arr2 = {4,5,6};
        int[] newArr = new int[6];

        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        for (int i = 0; i < arr.length; i++){
            newArr[i+3] = arr2[i];
        }
        System.out.println(Arrays.toString(newArr));

    }
}
