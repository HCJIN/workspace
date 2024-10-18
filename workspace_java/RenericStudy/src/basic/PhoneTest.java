package basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PhoneTest {
    public static void main(String[] args) {
        //PhoneBox의 타입인자는
        //Phone,MobilePhone, SmartPhone 만 들어올 수 있음
        //PhoneBox<String> p1 = new PhoneBox<>(); -> 오류 발생!

        PhoneBox<Phone> box1 = new PhoneBox<>();
        PhoneBox<MobliePhone> box2 = new PhoneBox<>();
        PhoneBox<SmartPhone> box3 = new PhoneBox<>();




    }
}
