package object;


import 상속.MobilePhone;

public class TvTest {
    public static void main(String[] args) {
        Tv tv = new Tv();

        //객체명.변수명, 객체명.메소드명으로 변수와 메소드 호출 가능
        System.out.println(tv.modelNumber);
        tv.powerOn();

        //Object 클래스는 모든 클래스의 부모클래스다.
        //자료형이 다르면 데이터 저장 불가
        //다형성에 의해서 부모클래스로 자식클래스 객체를 저장할 수 있다.
        Object o1 = new Tv();
        Object o2 = new MobilePhone();
        Object o3 = new LgTv();
//        Tv t1 = SsTv(); 오류 오브젝트만 자식의 자식 가져올수잇음




    }
}
