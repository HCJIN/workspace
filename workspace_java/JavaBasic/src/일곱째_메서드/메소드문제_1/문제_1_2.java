package 일곱째_메서드.메소드문제_1;

import java.util.Scanner;

public class 문제_1_2 {
    public static void main(String[] args) {
        System.out.println("13번문제 답 ------- "); num();
        System.out.print("14번문제 답 : "); num2(3);
        System.out.print("15번문제 답 : "); num3(4,7);
        System.out.print("16번문제 답 : "); num4(4);
        System.out.print("17번문제 답 : "); num5(2,10);
        System.out.println("18번문제 답 ------- "); num6(2,15);
        System.out.print("19번문제 답 : "); end("끝",5);
    }
    //13번문제
    public static void num(){
        Scanner sc = new Scanner(System.in);
        System.out.print("첫번째 정수 입력 : ");
        int a = sc.nextInt();
        System.out.print("두번째 정수 입력 : ");
        int b = sc.nextInt();
        System.out.println(a + b);
    }
    //14번문제
    public static void num2(int num2){
        if (num2 % 2 == 0){
            System.out.println("짝수입니다.");
        }else{
            System.out.println("홀수입니다.");
        }
//        삼항연산자
//        System.out.println(num2 % 2 == 0 ? "짝수" : "홀수");
    }
    //15번문제
    public static void num3(int num1, int num2){
        if (num1 % 2 == 0 && num2 % 2 == 0){
            System.out.println("두 수는 짝수입니다.");
        } else if (num1 % 2 == 0 || num2 % 2 == 0) {
            System.out.println("한 수만 짝수입니다.");
        }else{
            System.out.println("두 수는 홀수입니다.");
        }
    }
    //16번문제
    public static void num4(int num1){
        for (int i = 0; i < num1 + 1; i++){
            System.out.print(i);
        }
        System.out.println();
    }
    //17번문제
    public static void num5(int num1, int num2){
        int max = num1 > num2 ? num1 : num2;
        int min = num1 < num2 ? num2 : num1;

        for (int i = min+1; i < max; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    //18번문제
    public static void num6(int num1, int num2){
        int max = num1 > num2 ? num1 : num2;
        int min = num1 < num2 ? num2 : num1;
        int cnt = 0;

        for (int i = min+1; i < max; i++){
            if (i % 5 == 0){
                cnt++;
            }
        }
        System.out.print("5의 배수의 개수 : " + cnt);
        System.out.println();
    }
    //19번문제
    public static void end(String str, int num1){
        for (int i = 1; i <= num1; i++){
            System.out.print(str + " ");
        }
    }
}
