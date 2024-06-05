package 일곱째_메서드;

public class 메서드_4 {
    public static void main(String[] args) {
        introduce("하핳하하", 19, "울산");

        String a = "홍길동";

        int b = 40;

        String c = "서울";

        introduce(a, b, c);
    }

    public static void introduce(String name, int agg, String addr){
        System.out.println("제 이름은 " + name);
        System.out.println("제 나이는 " + agg);
        System.out.println("제 주소는 " + addr);
    }
}
