package 다섯째_반복문.While.반복문_2;

import 다섯째_반복문.For.For_1;

public class 반복문_3 {
    public static void main(String[] args) {
        int sum = 0;
        int i;

        for (i = 1; i < 100; i++){
            sum = sum + i;
            if (sum > 300) {
                break;
            }
         }
        System.out.println(sum);
        System.out.println(i);
    }
}



