package 네번째_조건문;

public class 문자열비교 {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;

        System.out.println(x==y);

        String s1 = "java";
        String s2 = "python";

        System.out.println(s1 == s2); //문자열 비교가 아님
        System.out.println("1" == "1"); //문자열 비교가 아님

        String name = "Kim";
        boolean result = name.equals("kim");
        System.out.println(result);

        String addr = "울산";

        if(addr.equals("울산")){

        }






    }
}
