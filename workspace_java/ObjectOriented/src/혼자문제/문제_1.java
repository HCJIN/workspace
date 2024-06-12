package 혼자문제;

import java.util.Arrays;

public class 문제_1 {
    public static void main(String[] args) {
        int max = 0;
        int min = 100;
        int[] arr = new int[10];
        int[] array = {1,5,3,8,2};

        for (int i = 0; i < arr.length; i++){
            int rand = (int)(Math.random() * 100 + 1);
            arr[i] = rand;
                if (arr[i] > max){
                    max = arr[i];
                }else if(arr[i] < max && arr[i] < min ){
                    min = arr[i];
                }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(max);
        System.out.println(min);




        System.out.println("max : " + max);
    }
}
