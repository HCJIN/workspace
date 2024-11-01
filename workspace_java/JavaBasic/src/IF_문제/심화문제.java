package IF_문제;

import java.util.Scanner;

public class 심화문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫번째 정수 입력 : ");
        int num1 = sc.nextInt();
        System.out.print("두번째 정수 입력 : ");
        int num2 = sc.nextInt();
        System.out.print("세번째 정수 입력 : ");
        int num3 = sc.nextInt();

        //1번 문제
        if(num1 + num2 > num3 && num1 < num2 + num3 && num1 + num3 > num2){
            System.out.println("삼각형 쌉가능");
        }else{
            System.out.println("응 안돼");
        }
        System.out.println("--------------심화1번 끝--------------------");

        //2번문제
        System.out.print("x y 값을 입력 하시오 : ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        if(x > 50 && x < 100 && y > 50 && y < 100){
            System.out.println("사각형안에 있습니다.");
        }else{
            System.out.println("사각형 밖에 있습니다.");
        }


        //3번문제
        System.out.print("369게임 정수 1~99중 입력 : ");
        int num4 = sc.nextInt();
        int con = 0;

        if(num4 / 10 == 3 || num4 / 10 == 6 || num4 / 10 == 9){
            con++;
        }
        if(num4 % 10 == 3 || num4 % 10 == 6 || num4 % 10 == 9){
            con++;
        }
        if(con == 0){
            System.out.println("암것도 아님");
        } else if (con == 1) {
            System.out.println("박수짝");
        }else{
            System.out.println("박수짝짝");
        }
        System.out.println("--------------심화3번 끝--------------------");


        //999번
        int num5 = sc.nextInt();
        int con2 = 0;

        if(num5 / 100 == 3 || num5 / 100 == 6 || num5 / 100 == 9){
            con2++;
        }
        if(num5 / 10 / 10 == 3 || num5 / 10 / 10 == 6 || num5 / 10 / 10 == 9){
            con2++;
        }
        if(num5 % 10 == 3 || num5 % 10 == 6 || num5 % 10 == 9){
            con2++;
        }

        if(con2 == 3){
            System.out.println("박수 짝짝짝");
        } else if (con2 == 2) {
            System.out.println("박수 짝짝");
        } else if (con2 == 1) {
            System.out.println("박수 짝");
        }else{
            System.out.println("암것도 아님");
        }
    }
}
