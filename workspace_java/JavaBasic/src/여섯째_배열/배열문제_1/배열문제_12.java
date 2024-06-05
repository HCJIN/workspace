package 여섯째_배열.배열문제_1;

import java.util.Scanner;

public class 배열문제_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("국어 점수 입력 : ");
        int ko = sc.nextInt();
        System.out.print("영어 점수 입력 : ");
        int en = sc.nextInt();
        System.out.print("수학 점수 입력 : ");
        int ma = sc.nextInt();

        int[] score = new int[3];
        score[0] = ko;
        score[1] = en;
        score[2] = ma;

        int sum = score[0] + score[1] + score[2];
        double avg = sum / 3.0;

        System.out.println("총 점 : " + sum);
        System.out.println("평 균 : " + avg);


    }
}
