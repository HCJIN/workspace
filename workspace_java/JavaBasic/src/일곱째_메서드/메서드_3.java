package 일곱째_메서드;

//매개변수(parameter) : 메소드 정의 부분 소괄호 안에서 정의된 변수

public class 메서드_3 {
    public static void main(String[] args) {
        tellYourName("이응잉");
        tellYourName("우이잉");

        //tellYourName(5); 매개변수의 자료형 일치 필요!
    }

    public static void tellYourName(String name){ // String name = "이응잉";
        System.out.println("제 이름은 " + name);
    }
}
