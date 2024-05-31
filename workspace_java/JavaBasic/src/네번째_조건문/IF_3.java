package 네번째_조건문;

import java.util.Scanner;

public class IF_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력 하시오 : ");
        int num = sc.nextInt();

        //만약에...
        if(num > 0){
            System.out.println(1);
        }
        //그렇지 않고 만약에...
        else if(num < 0){
            System.out.println(2);
        }else {
            System.out.println(0);
        }
    }
}
