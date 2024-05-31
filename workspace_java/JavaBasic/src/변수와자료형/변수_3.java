package 변수와자료형;

public class 변수_3 {
    public static void main(String[] args) {
        int num1;
        int num2;

        num1 = 10;
        num2 = 20;

        // 두 변수에 저장된 값을 바꾸기 전
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("-------------------------------");

        //이 곳에 두 변수의 값을 바꾸는 코드를 작성

        int num3;

        num3 = num1;
        num1 = num2;
        num2 = num3;

        // 두 변수에 저장된 값을 바꾼 후
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

    }
}
