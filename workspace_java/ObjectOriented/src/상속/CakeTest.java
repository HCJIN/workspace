package 상속;

public class CakeTest {
    public static void main(String[] args) {
        cheeseCake c = new cheeseCake();
        c.eat(); //자식클래스에서 재정의한 메소드가 실행

        //c객체로부터 부모클래스에서 선언한 eat() 메소드를 호출 할 수 있냐? X


    }
}
