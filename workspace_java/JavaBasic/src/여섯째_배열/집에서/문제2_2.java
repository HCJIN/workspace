package 여섯째_배열.집에서;

import java.util.Arrays;

public class 문제2_2 {
    public static void main(String[] args) {
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
            int cnt = 0;
            for (int j = 1; j <= i; j++){
                if (i%j == 0){
                    cnt = cnt + 1;
                }
            }
            if(cnt == 2) {
                System.out.println(Arrays.toString(arr));
            }
        }



    }
}
