package class_basic.account_calc;

import java.util.Scanner;

public class CalcTest {
    public static void main(String[] args) {
        Add ad = new Add();
        Sub su = new Sub();
        Mul mu = new Mul();
        Div di = new Div();
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 수 : ");
        int a = sc.nextInt();
        System.out.print("두 번째 수 : ");
        int b = sc.nextInt();
        System.out.print("연산자 : ");
        String sub = sc.next();
        ad.setValue(a, b);
        su.setValue(a, b);
        mu.setValue(a, b);
        di.setValue(a, b);
        if (sub.equals("+")){
            System.out.println(a + " " + b + " " + sub + " = " + ad.calculate());
        } else if (sub.equals("-")) {
            System.out.println(a + " " + b + " " + sub + " = " + su.calculate());
        } else if (sub.equals("*")) {
            System.out.println(a + " " + b + " " + sub + " = " + mu.calculate());
        } else if (sub.equals("/")) {
            System.out.println(a + " " + b + " " + sub + " = " + di.calculate());
        }

    }
}
