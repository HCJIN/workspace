package IF_문제_강사님풀이;

import java.util.Scanner;

public class Text_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("1~99 사이의 정수를 입력하시오 : ");
        int num = sc.nextInt();

        int tens = num / 10;
        int ones = num % 10;

        int clapCnt = 0;

        if(tens == 3 || tens == 6 || tens == 9){
            clapCnt++;
        }
        if(ones == 3 || ones == 6 || ones == 9){
            clapCnt++;
        }
        if(clapCnt == 1){
            System.out.println("박수짝");
        } else if (clapCnt == 2) {
            System.out.println("박수짝짝");
        }else{
            System.out.println("응 아무것도 아니야");
        }


    }
}
