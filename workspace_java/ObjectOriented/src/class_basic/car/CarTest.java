package class_basic.car;

public class CarTest {
    public static void main(String[] args) {

        Car c1 = new Car();

        //c1의 변수를 출력
        System.out.println(c1.brand);
        System.out.println(c1.price);

        //c1 변수의 메소드를 통한 값 변경
        c1.setBrand("포르쉐");
        c1.setPrice(160000000);
        System.out.println(c1.brand);
        System.out.println(c1.price);

        System.out.println("----------------------");

        Car c2 = new Car();
//        c2.printCarInfo();

        //바로 접근 사용
        c2.brand = "포르쉐";

        c2.setModelName("카이엔");
        c2.setCarNumber("1111");
        c2.setPrice(157000000);
        c2.setOwner("이츠 미");

        c2.printCarInfo();





    }
}
