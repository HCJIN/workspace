package Interface;


//Machine 인터페이스에 정의한 메소드를 구현한 CoffeeMachine 클래스를 생성하겠다.
//인터페이스를 구현한 클래스는 맴버변수, 생성자 등 나머지 부분은 클래스와 동일하게 사용
public class CoffeeMachine implements Machine{

    @Override
    public void takeCoffee() {
        System.out.println("커피 맛이 좋았어");
    }

    @Override
    public void takeMilk() {
        System.out.println("우유가 나옵니다");
    }
}
