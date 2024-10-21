public interface Printable {

    void print(); //추상 메서드

}

//람다 적용을 위해서는 인터페이스에
//하나의 추상메서드만 존재해야 함!
//추상메서드가 하나만 존재하는 인터페이스 -> 함수형 인터페이스
interface Getterable {
    void getNum();
}
