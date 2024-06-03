package IF_문제_강사님풀이;

import java.util.Scanner;

public class Text_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫번째 변의 길이 : ");
        int a = sc.nextInt();
        System.out.print("두번째 변의 길이 : ");
        int b = sc.nextInt();
        System.out.print("세번째 변의 길이 : ");
        int c = sc.nextInt();

        if(a + b > c && a + c > b && b + c > a ){
            System.out.println("삼각형 쌉가능");
        }else {
            System.out.println("응 안돼");
        }
    }
}
