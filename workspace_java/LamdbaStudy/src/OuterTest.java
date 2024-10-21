public class OuterTest {
    public static void main(String[] args) {
        //Outer 클래스 객체 생성
        Outer outer = new Outer();

        //Board 클래스의 객체 생성
        Outer.Board b = outer.new Board();
        b.printNum();
    }
}
