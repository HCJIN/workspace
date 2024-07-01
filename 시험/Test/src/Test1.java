import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("세 정수를 입력 하시오 : ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int a = 0;
        int b = 0;
        int c = 0;

        if (num1 > num2 && num1 > num3){
            a = num1;
            if(num2 > num3){
                b = num2;
                c = num3;
            }else {
                b = num3;
                c = num2;
            }
        }else if(num2 > num1 && num2 > num3){
            a = num2;
            if(num1 > num3){
                b = num1;
                c = num3;
            }else{
                b = num3;
                c = num1;
            }
        }else if (num3 > num1 && num3 > num2) {
           a = num3;
           if (num1 > num2){
               b = num1;
               c = num2;
           }else{
               b = num2;
               c = num1;
           }
        }
        System.out.println(a + " > " + b + " > "  + c);
    }
}
