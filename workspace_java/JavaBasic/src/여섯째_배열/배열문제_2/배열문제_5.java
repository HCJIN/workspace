package 여섯째_배열.배열문제_2;

import java.util.Arrays;

public class 배열문제_5 {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};

        int[] newArr = new int[5];

        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        System.out.println(Arrays.toString(newArr));

        System.out.println("---------------강사님 풀이----------------");

        for (int e : newArr){
            System.out.print("[ " + e + " " + "]");
        }




    }
}
