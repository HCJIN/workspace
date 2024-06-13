package object;

public class String_1 {
    public static void main(String[] args) {
        //문자열 객체 생성 방법
        String name1 = "java";
        String name2 = new String("java");

        //String 객체의 특이점
        String name3 = name1;
        name1 = "python";
        System.out.println(name3);
        System.out.println(name1);
    }
}
