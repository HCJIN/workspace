package basic;

import java.util.List;

public class GenericMethodTest {
    public static void main(String[] args) {
        GenericMethod.aaa();
        //제네릭 메서드의 자료형은 메서드 호출 시 결정
        Box<String> b1 = GenericMethod.makeBox("java");
        Box<Integer> b2 = GenericMethod.makeBox(10);

        Box<String> box1 = new Box<>();
        GenericMethod.peekBox(box1);




    }
}
