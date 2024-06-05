package 여섯째_배열.배열문제_1;

import java.util.Scanner;

// (난이도 상) 간단한 성적처리 시스템을 만들어보자.
// 국어, 영어, 수학점수를 입력받아 각 과목에 대한
// 점수 및 총점, 평균을 출력하는 프로그램을 만들어보자.
// 반드시 배열을 사용하도록 한다.
public class 배열문제_12_강사님 {
    public static void main(String[] args) {
        //변수 선언
        Scanner sc = new Scanner(System.in);
        //0:국어, 1:영어, 2:수학, 3:사회, 4:과학, 5:총점
        int[] scores = new int[6];
        //과목명
        String[] subjects = {"국어", "영어", "수학", "사회", "과학"};
        //평균
        double avg;

        //점수입력(0~100점 입력까지 무한 입력)
        for (int i = 0; i < scores.length-1; i++){
            while (true){
                System.out.print( subjects[i] + " 점수 : ");
                scores[i] = sc.nextInt();

                if (scores[i] >= 0 && scores[i] <= 100){
                    break;
                }
            }
        }

        //총점 및 평균
        for (int i = 0; i < scores.length-1; i++){
            scores[scores.length-1] = scores[scores.length-1] + scores[i];
        }
        avg = scores[scores.length-1] / (double)(scores.length-1) ;

        //점수 및 총점 평균 출력
        System.out.println();
        System.out.println("---- 입력한 정보입니다 ----");
        for (int i = 0; i < subjects.length; i++){
            System.out.println(subjects[i] + "점수는 = " + scores[i]);
        }
        System.out.println("총점 = " + scores[scores.length-1]);
        System.out.println("평균 = " + avg);

    }
}
