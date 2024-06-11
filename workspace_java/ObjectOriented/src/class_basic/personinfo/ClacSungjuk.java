package class_basic.personinfo;

import java.util.Scanner;

public class ClacSungjuk {
    public static void main(String[] args) {
        Student st1 = new Student();
        Student st2 = new Student();
        Student st3 = new Student();

        Scanner sc = new Scanner(System.in);
        System.out.print("학생 이름 : ");
        String name  = sc.next();
        System.out.print("나이 : ");
        int age = sc.nextInt();
        System.out.print("주소 : ");
        String addr = sc.next();
        System.out.println("국어 점수 : ");
        int ko = sc.nextInt();
        System.out.println("영어 점수 : ");
        int en = sc.nextInt();
        System.out.println("수학 점수 : ");
        int ma = sc.nextInt();

        st1.setInfo(name, age, addr);
        st1.setSongjuk(ko,en,ma);
        st1.displayStudentInfo();
        st2.setInfo(name, age, addr);
        st2.setSongjuk(ko,en,ma);
        st2.displayStudentInfo();
        st3.setInfo(name, age, addr);
        st3.setSongjuk(ko,en,ma);
        st3.displayStudentInfo();
    }

}
