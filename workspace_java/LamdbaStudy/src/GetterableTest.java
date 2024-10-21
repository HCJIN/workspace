public class GetterableTest {
    public static void main(String[] args) {

        Getterable g = () -> {
            System.out.println(10);
            System.out.println(10);
        };

        g.getNum();

        //조금 더 줄여보자
        //람다로 구현한 메서드의 내용 부분이 한 줄이라면 {} 생략 가능
        Getterable g1 = () -> System.out.println(10);
        g1.getNum();

    }
}

