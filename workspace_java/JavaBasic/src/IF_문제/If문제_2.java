package IF_문제;

import java.sql.SQLOutput;
import java.util.Scanner;

public class If문제_2 {
    public static void main(String[] args) {
        //5번문제
        Scanner sc = new Scanner(System.in);

        System.out.print("첫번째 정수 입력 : ");
        int num1 = sc.nextInt();
        System.out.print("두번째 정수 입력 : ");
        int num2 = sc.nextInt();
        System.out.print("세번째 정수 입력 : ");
        int num3 = sc.nextInt();

        int max;
        int min;

        if (num1 > num2) {
            max = num1;
            min = num2;
        } else {
            max = num2;
            min = num1;
        }
        System.out.println(max + " > " + min);
        System.out.println("------------5번문제 끝-----------------");

        //6번문제
        if (num1 > num2) {
            if (num3 > num1) {
                System.out.println(num3 + " > " + num1 + " > " + num2);
            } else if (num3 < num1) {
                if(num3 > num2){
                    System.out.println(num1 + " > " + num3 + " > " + num2);
                }else{
                    System.out.println(num1 + " > " + num2 + " > " + num3);
                }
            }
        }else if(num1 < num2) {
            if (num3 > num2) {
                System.out.println(num3 + " > " + num2 + " > " + num1);
            } else if (num3 < num2) {
                if(num3 < num1){
                    System.out.println(num2 + " > " + num1 + " > " + num3);
                }else{
                    System.out.println(num2 + " > " + num3 + " > " + num1);
                }
            }
        }
        System.out.println("------------6번문제 끝-----------------");
    }
}
