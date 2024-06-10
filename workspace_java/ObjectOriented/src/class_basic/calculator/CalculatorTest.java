package class_basic.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator c1 = new Calculator();

        System.out.print("첫 번째 수 : ");
        c1.num1 = sc.nextInt();
        System.out.print("두 번째 수 : ");
        c1.num2 = sc.nextInt();
        System.out.print("연산자를 입력 : ");
        String add = sc.next();

        if (add.equals("+")){
            System.out.println(c1.num1 +" " + add + " " + c1.num2 + " = " +  c1.setPlus(c1.num1, c1.num2));
        } else if (add.equals("-")) {
            System.out.println(c1.num1 +" " + add + " " + c1.num2 + " = " +  c1.setMinu(c1.num1, c1.num2));
        } else if (add.equals("*")) {
            System.out.println(c1.num1 +" " + add + " " + c1.num2 + " = " +  c1.setGob(c1.num1, c1.num2));
        } else if (add.equals("/")) {
            System.out.println(c1.num1 +" " + add + " " + c1.num2 + " = " +  c1.setslash(c1.num1, c1.num2));
        }

    }
}