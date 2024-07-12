package 시험자바첫번째;

import java.util.Scanner;

public class 문제4번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("숫자 입력 : ");
        int num = sc.nextInt();

        //백의 자리 숫자
        int huns = num / 100;

        //십의 자리 512
        int tens = ( num % 100 ) / 10;

        //일의 자리 512
        int ones = num % 10;

        int clapCnt = 0;

        if(huns == 3 || huns == 6 || huns == 9){
            clapCnt++;
        }
        if(tens == 3 || tens == 6 || tens == 9){
            clapCnt++;
        }
        if(ones == 3 || ones == 6 || ones == 9){
            clapCnt++;
        }





    }
}
