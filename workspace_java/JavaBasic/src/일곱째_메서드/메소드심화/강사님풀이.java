package 일곱째_메서드.메소드심화;

import java.util.Arrays;

public class 강사님풀이 {
    public static void main(String[] args) {
//        int[] a = {1,7,5,3,2};
//        System.out.println(test6(a));

//        String[] a = {"집","에","가","자"};
//        System.out.println(test7(a));

        int[] a = {1,2,3,4,5};
        int[] result = test9(a);
        System.out.println(Arrays.toString(result));

    }

    //6번문제
    public static int test6(int[] array){ //가정 1 7 5 3 2
        int max = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;
    }
    //7번문제
    public static String test7(String[] arr){
        String result = "";
        for (int i = 0; i < arr.length; i++){
            result = result + arr[i];
        }
        return result;
    }
    //9번문제
    public static int[] test9(int[] array){
        //매개변수로 넘어온 배열 요소 중 짝수의 개수
        int cnt = 0;
        for ( int e : array){
            if (e % 2 == 0){
                cnt++;
            }
        }

        //짝수만 저장될 배열 생성
        int[] resultArr = new int[cnt];

        int index = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0){
                resultArr[index] = array[i];
                index++;
            }
        }

        return resultArr;


    }

}
