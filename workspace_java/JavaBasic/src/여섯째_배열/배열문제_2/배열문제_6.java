package 여섯째_배열.배열문제_2;

import java.util.Arrays;

public class 배열문제_6 {
    public static void main(String[] args) {
//        int[] arr1 = {1,2,3};
//        int[] arr2 = {4,5,6};
//
//        int[] newArr = new int[6];
//
//        for (int i = 0; i < arr1.length; i++){
//            newArr[i] = arr1[i];
//        }
//        for (int j = 0; j < arr2.length; j++){
//            newArr[j+3] = arr2[j];
//        }
//        System.out.println(Arrays.toString(newArr));
        System.out.println("---------------강사님 풀이----------------");

        int[] arr_1 = {1,2,3,8,9,0};
        int[] arr_2 = {4,5,6};

        int[] newArr2 = new int[arr_1.length + arr_2.length];

        for (int i = 0; i < arr_1.length; i++){
            newArr2[i] = arr_1[i];
        }
        for (int i =0; i < arr_2.length; i++){
            newArr2[i + arr_1.length] = arr_2[i];
        }
        System.out.println(Arrays.toString(newArr2));
        for (int e : newArr2){
            System.out.print(e);
        }












    }
}
