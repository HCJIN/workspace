package 일곱째_메서드.메소드문제_1;

import java.util.Scanner;

public class 문제_1 {
    public static void main(String[] args) {
        System.out.print("1번문제 답 : "); hello();
        System.out.print("2번문제 답 : "); hello_2(); hello_2_2();
        System.out.print("3번문제 답 : "); num(30);
        System.out.print("4번문제 답 : "); str("잠온당");
        System.out.print("5번문제 답 : "); num2(4,9);
        System.out.print("6번문제 답 : "); num3(4,9,6);
        System.out.print("7번문제 답 : "); num4(10, 3);
        System.out.print("8번문제 답 : "); str2("너무", "졸리다");
        System.out.println("9번문제 답 : ");
        introN("홍길동");
        introA(33);
        introadd("울산");
        System.out.println("10번문제 답 ------ ");
        intro("임",50,"울산");
        System.out.print("11번문제 답 : "); num4(8);
        System.out.println("12번문제 답 ------ ");
        introduce();

    }

    //1번문제
    public static void hello(){
        System.out.println("안녕하세요");
    }
    //2번문제
    public static void hello_2(){
        System.out.print("반갑습니다 ");
    }
    public static void hello_2_2(){
        System.out.print("어서오세요");
        System.out.println();
    }
    //3번문제
    public static void num(int num){
        System.out.println(num);
    }
    //4번문제
    public static void str(String str1){
        System.out.println(str1);
    }
    //5번문제
    public static void num2(int a, int b){
        System.out.println(a + b);
    }
    //6번문제
    public static void num3(int c, int d, int e){
        System.out.println(c * d * e);
    }
    //7번문제
    public static void num4(int i, int j){
        System.out.print(i / (double)j + " ");
        System.out.println(i % j);
    }
    //8번문제
    public static void str2(String cha1, String cha2){
        System.out.println(cha1 +" "+ cha2);
    }
    //9번문제
    public static void introN(String name){
        System.out.println("이름은 " + name + "입니다.");
    }
    public static void introA(int age){
        System.out.println("나이는 " + age+"살입니다");
    }
    public static void introadd(String add){
        System.out.println("주소는 " + add + "입니다.");
    }
    //10번문제
    public static void intro(String name, int age, String add){
        introN(name);
        introA(age);
        introadd(add);
    }
    //11번문제
    public static void num4(int num){
        System.out.println("입력받은 정수 : " + num);
    }
    //12번문제
    public static void introduce(){
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = sc.next();
        introN(name);
        System.out.print("나이 : ");
        int age = sc.nextInt();
        introA(age);
        System.out.print("주소 : ");
        String add = sc.next();
        introadd(add);
    }
}
