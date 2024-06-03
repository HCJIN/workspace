package IF_문제;

import java.util.Scanner;

public class IF_Switch문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 두 수를 입력하시오 : ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.print("연산자를 입력하시오 : ");
        String plus = sc.next();

        if(plus.equals("+")){
            System.out.println("첫번째 수 : " + num1);
            System.out.println("두번째 수 : " + num2);
            System.out.println("연산자 : " + plus);
            System.out.println(num1 + " " +  plus  +" " + num2 + " = " + (num1 + num2));
        } else if (plus.equals("-")) {
            System.out.println("첫번째 수 : " + num1);
            System.out.println("두번째 수 : " + num2);
            System.out.println("연산자 : " + plus);
            System.out.println(num1 + " " +  plus  +" " + num2 + " = " + (num1 - num2));
        } else if (plus.equals("*")) {
            System.out.println("첫번째 수 : " + num1);
            System.out.println("두번째 수 : " + num2);
            System.out.println("연산자 : " + plus);
            System.out.println(num1 + " " +  plus  +" " + num2 + " = " + (num1 * num2));
        } else if (plus.equals("/")) {
            System.out.println("첫번째 수 : " + num1);
            System.out.println("두번째 수 : " + num2);
            System.out.println("연산자 : " + plus);
            System.out.println(num1 + " " +  plus  +" " + num2 + " = " + (num1 / (double)num2));
        }else{
            System.out.println("연산자를 잘못 입력하였습니다.");
        }
        System.out.println("------------if문제 끝-----------------------");

        switch (plus){
            case "+" :
                System.out.println("첫번째 수 : " + num1);
                System.out.println("두번째 수 : " + num2);
                System.out.println("연산자 : " + plus);
                System.out.println(num1 + " " +  plus  +" " + num2 + " = " + (num1 + num2));
                break;
            case "-" :
                System.out.println("첫번째 수 : " + num1);
                System.out.println("두번째 수 : " + num2);
                System.out.println("연산자 : " + plus);
                System.out.println(num1 + " " +  plus  +" " + num2 + " = " + (num1 - num2));
                break;
            case "*" :
                System.out.println("첫번째 수 : " + num1);
                System.out.println("두번째 수 : " + num2);
                System.out.println("연산자 : " + plus);
                System.out.println(num1 + " " +  plus  +" " + num2 + " = " + (num1 * num2));
                break;
            case "/" :
                System.out.println("첫번째 수 : " + num1);
                System.out.println("두번째 수 : " + num2);
                System.out.println("연산자 : " + plus);
                System.out.println(num1 + " " +  plus  +" " + num2 + " = " + (num1 / (double)num2));
                break;
            default:
                System.out.println("연산자를 잘못 입력하였습니다.");
        }
        System.out.println("------------switch문제 끝-----------------------");

    }
}
