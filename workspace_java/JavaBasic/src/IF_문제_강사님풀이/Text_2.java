package IF_문제_강사님풀이;

import java.util.Scanner;

public class Text_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("점 ( x, y ) 값을 입력하시오 : ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        if(x >= 50 && x <= 100 && y >= 50 && y <= 100){
            System.out.println("입력한 좌표는 사각형 내부에 있습니다.");
        }else{
            System.out.println("좌표 똑바로 찍어라.");
        }


    }
}
