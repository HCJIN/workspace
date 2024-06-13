package 스태틱;

public class InitTest {
    public static void main(String[] args) {
        StaticInit st1 = new StaticInit();
        StaticInit st2 = new StaticInit();
        StaticInit st3 = new StaticInit();

        //static 변수를 읽고 사용하는 방법
        //객체명.변수명으로 static 변수도 사용가능. 추천하지 않는 방법
        System.out.println(st1.num);
        System.out.println(st2.num);

        //static변수 및 메소드는
        //클래스명.변수명
        //이러한 접근 방법은 객체를 만들지 않아도 사용 가능
        System.out.println(StaticInit.num);

        /////////////////////////////////////////

        //객체명.메소드명
        //Math 대문자 클래스명 random(); 랜덤 메소드
        //클래스명.변수명 random(); 메소드도 static 이 붙어있다는걸 알 수 있다.
        //Math 는 대부분 static 이 달려있다.
        //Math.random();

        ////////////////////////////////////////



    }
}
