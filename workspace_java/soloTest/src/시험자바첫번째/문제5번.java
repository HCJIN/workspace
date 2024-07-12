package 시험자바첫번째;

import java.util.Scanner;

public class 문제5번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //문제 1~9 까지 랜덤 정수 중복 없이 저장
        int[] baseball = new int[3];

        for (int i = 0; i < baseball.length; i++){
            int rand = (int)(Math.random() * 9 + 1);
            baseball[i] = rand;

            //중복 검사
            for (int j = 0; j < i; j++){
                if (baseball[j] == baseball[i]){
                    i--;
                    break;
                }

            }

        }

        //대답
        int[] answer = new int[3];

        System.out.println("게임을 시작합니다 ! ");

        int tryCnt = 0;




        while (true){
            tryCnt++;
            System.out.print(tryCnt + " >> ");

            answer[0] = sc.nextInt();
            answer[1] = sc.nextInt();
            answer[2] = sc.nextInt();

            //정답대조
            //baseball = [5,1,2]
            //answer   = [1,2,3]
            int strike = 0;
            int ball = 0;

            for (int i = 0; i < baseball.length; i++){
                for (int j = 0; j < answer.length; j++){
                    if (baseball[i] == answer[j] && i == j){
                        strike++;
                    }
                    else if (baseball[i] == answer[j]){
                        ball++;
                    }
                }
            }
            System.out.println(strike + "S " + ball + "B");

            if (strike == 3){
                System.out.println(tryCnt+"회만에 정답을 맞췄습니다");
                break;
            }
        }
    }
}
