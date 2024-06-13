package Interface;

public class TvUser {
    public static void main(String[] args) {
        //인터페이스를 구현한 클래스의 생성자로 인터페이스 객체 생성
        //인터페이스명 객체명 = new 생성자명
        Tv tv = new SamsungTv();
        tv.turnOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.turnOff();

    }
}
