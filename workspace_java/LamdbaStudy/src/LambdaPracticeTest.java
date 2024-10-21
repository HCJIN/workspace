public class LambdaPracticeTest {
    public static void main(String[] args) {

        //람다를 이용해서 LambdaPractice 인터페이스 안의
        //printName 메서드의 기능을 "홍길동입니다"가
        //출력될 수 있또록 구현하고, 호출하여 확인해보세요.
        //매개변수가 없으면 매개변수 자리의 소괄호 생략 불가!
        LambdaPractice lam = () -> System.out.println("홍길동입니다.");
        lam.printName();

        //매개변수 자료형도 생략 가능
        //매개변수가 하나라면 매개변수 자료의 소괄호 생략 가능
        LambdaPractice1 lam1 = name -> System.out.println(name + "입니다");
        lam1.printName("홍길동");

        LambdaPractice2 lam2 = (name, age) -> System.out.println("이름은 " + name + "이고 나이는 " + age + "입니다.");
        lam2.printName("홍길동",22);

        //리턴 타입이 있는 람다식은 {} 생략 불가!
        //중괄호를 생략하려면 'return' 키워드도 같이 생략!
        LambdaPractice3 lam3 = () ->  10 ;
        System.out.println(lam3.getData());

        LambdaPractice4 lam4 = (a, b) -> a + b;
        System.out.println(lam4.getResult(3, 4));

    }
}
