package 여섯째_배열.집에서;

import java.util.Arrays;

public class 문제심화1 {
    public static void main(String[] args) {
        int max = 0;
        int[] arr = {1,5,3,8,2};

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("max : " + max);
    }
}
