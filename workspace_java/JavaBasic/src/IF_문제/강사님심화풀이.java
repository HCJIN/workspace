package IF_문제;

import java.util.Scanner;

public class 강사님심화풀이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int max, mid, min;


        //a가 가장 큰수
            if(a > b && a > c){
                max = a;
                if(b > c){
                    mid = b;
                    min = c;
                }else{
                    mid = c;
                    min = b;
                }
            }
            //b가 가장 큰수
            else if (b > a && b > c ) {
                max = b;
                if(a > c){
                    mid = a;
                    min = c;
                }else{
                    mid = c;
                    min = a;
                }
            }
            //c가 가장 큰수
            else{
                max = c;
                if(a > b){
                    mid = a;
                    min = b;
                }else{
                    mid = b;
                    min = a;
                }
            }
        System.out.println(max + " > " + mid + " > " + min);
    }
}
