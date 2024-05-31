package 변수와자료형;

public class 숫자연산 {
    public static void main(String[] args) {

        System.out.println(10 + 10); //20

        //정수끼리의 연산 결과는 정수!
        System.out.println(10/4); //2
        System.out.println((double)10 / 4); //2.5
        //실수끼리의 연산 결과는 실수!
        System.out.println(10.0 / 4.0); // 2.5
        //정수와 실수끼리의 결과는 실수!
        System.out.println(10 / 4.0); // 2.5
        System.out.println(10 / 3 * 1.5);
    }
}
