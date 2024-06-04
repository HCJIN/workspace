package 여섯째_배열.배열문제_2;

import java.util.Arrays;

public class 배열문제_8 {
    public static void main(String[] args) {
        int[] arr = new int[6];
            for (int a = 0; a < arr.length; a++){
                int i = (int)(Math.random() * 40 + 5);
                arr[a] = i;
            }
        System.out.println(Arrays.toString(arr));
    }
}
