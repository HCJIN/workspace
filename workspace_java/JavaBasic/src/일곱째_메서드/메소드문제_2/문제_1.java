package 일곱째_메서드.메소드문제_2;

import javax.swing.*;
import java.util.Scanner;
import java.util.Stack;

public class 문제_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 2개를 입력 : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("1번문제 답 : " + test1(1,3));
        System.out.println("2번문제 답 : " + test2(a, b));
        System.out.println("3번문제 답 : " + test3(10,9));
        System.out.println("4번문제 답 : " + test4("집에"," 가고싶다"));
        System.out.println("5번문제 답 : " + test5(91));
        System.out.println("6번문제 답 : " + test6(91));
        System.out.println("7번문제 답 : " + test7(4.5));
        System.out.println("8번문제 답 : " + test8(6,9,84));
        System.out.println("9번문제 답 : " + test9(5));
    }

    //1번문제
    public static int test1(int a, int b){
        return a +b;
    }
    //2번문제
    public static int test2(int a, int b){
        return a * b;
    }
    //3번문제
    public static int test3(int a, int b){
        int max = a > b ? a : b;
        return max;
    }
    //4번문제
    public static String test4(String a, String b){
        return a + b;
    }
    //5번문제
    public static String test5(int a){
        if (a >= 90){
            return "A";
        } else if (a >= 70 && a <= 89) {
            return "B";
        } else{
            return "C";
        }
    }
    //6번문제
    public static String test6(int a) {
        //정수 -> 문자열
        String bb = String.valueOf(10);//"10"

        //문자열 -> 정수
        int aa = Integer.parseInt("10"); //10


        return "" + a;
    }
    //7번문제
    public static double test7(double a){
        return a * a;
    }
    //8번문제
    public static double test8(int a, int b, int c){
        int sum = a + b + c;
        double avg = sum / (double)3;

        return avg;
    }
    //9번문제
    public static int test9(int a){
        int sum = 0;
        for (int i = 1; i <= a; i++){
            if (i % 2 != 0){
                sum = sum + i;
            }
        }
        return sum;
    }

}
