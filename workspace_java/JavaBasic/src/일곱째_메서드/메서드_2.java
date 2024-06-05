package 일곱째_메서드;

public class 메서드_2 {
    public static void main(String[] args) {
        System.out.println("시작");
        tellYourName();
        tellYoureAge();
        System.out.println("종료");
    }

    public static void tellYourName(){
        System.out.println("와타시");
    }

    public static void tellYoureAge(){
        System.out.println("서른마흔다섯");
        tellYourAddr();
    }

    public  static void tellYourAddr(){
        System.out.println("울산");
    }
}
