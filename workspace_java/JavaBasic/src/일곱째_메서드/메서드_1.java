package 일곱째_메서드;


//메소드(Method) == 함수(Function)
//메소드는 반복해서 실행하는 코드를 미리 하나의 기능으로 정의
//메소드의 사용은 크게 메소드 정의 부분과 메소드호출 부분으로 나뉨.
//메소드를 사용하려면 반드시 메소드 정의 후 호출을 해야 함!

//메소드의 정의는 클래스 안, 다른 메소드 밖에서 선언한다.
//메소드는 필요한 만큼 무한정 정의할 수 있음
//메소드명은 중복 불가(대소문자 구분)
//메소드명 항상 소문자로 작명한다.

//메소드의 호출은 메소드의 정의 안에서 호출
//메소드를 호출할 때는 정의한 메소드명을 반드시 일치시켜야함.
//메소드를 호출할 때는 정의한 메소드의 매개변수 정보를 일치시켜야 함.
//매개변수 정보 : 매개변수의 자료형, 매개변수의 갯수


//메소드의 정의 문법
/*
    접근제한자 리턴타입 메소드명(매개변수 정보){

    }

    public static void 메소드명(){

    }


*/


public class 메서드_1 {

    //메소드의 정의
    public static void hello(){
        System.out.println("hello~");

    }

    public static void main(String[] args) {

        //메소드의 호출
        hello(); hello();
    }
}
