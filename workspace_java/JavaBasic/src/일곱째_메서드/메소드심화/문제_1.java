package 일곱째_메서드.메소드심화;

import java.util.Arrays;

public class 문제_1 {
    public static void main(String[] args) {
//        System.out.println("1번 문제 답 ------"); test1(10);
//        System.out.print("2번 문제 답 : "); test2(3);
//        System.out.print("3번 문제 답 : " + test3());
//        System.out.print("4번 문제 답 : " + test4(5));
//        int[] b = {1, 3, 5};
//        System.out.print("5번 문제 답 : "); test5(b);
//        int[] b = {1, 3, 5 ,7};
//        System.out.print("6번 문제 답 : ");
//        System.out.println(test6(b));
//        String[] d = {"j","a","v","a"};
//        System.out.print("7번 문제 답 : ");
//        System.out.println(Arrays.toString(test7(d)));
//        int[] a = {1,2,3};
//        int[] b = {4,5,6};
//        System.out.print("8번 문제 답 : ");
//        System.out.println(Arrays.toString(test8(a, b)));//
//        int[] c = {1,2,3,4,5,6,7,8,9,10};
//        System.out.print("9번 문제 답 : ");
//        System.out.println(Arrays.toString(test9(c)));



    }

    //1번문제
    public static void test1(int a){
        for (int i = 1; i < 10; i++){
            System.out.println(a + " x " + i + " = " + i * a );
        }
    }
    //2번문제
    public static void test2(int a){
        for (int i = 1; i < 101; i++){
            if (i % a == 0){
                System.out.print(i + " ");
            }
        }
    }
    //3번문제
    public static int test3(){
        // 0.0 >= x > 1.0
        int i = (int)(Math.random() * 50 + 1);
        return i;
    }
    //4번문제
    public static boolean test4(int a){
        boolean b = a % 2 == 0 ? true : false;
        // 축약 return a % 2 == 0;
        return b;
    }
    //5번문제
    public  static void test5(int[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
    //6번문제
    public  static int test6(int[] a){
        int max = a[0];
        for (int i = 0; i < a.length; i++){
            if (a[i] > max){
                max = a[i];
            }
        }
        return max;
    }
    //7번문제
    public static String[] test7(String[] a){
        for (int i = 0; i < a.length; i++){
            a[i] = "" + a[i];
        }
        return a;
    }
    //8번문제
    public static int[] test8(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++){
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++){
            c[i + a.length] = b[i];
        }
        return c;
    }
    //9번문제
    public static int[] test9(int[] a){
                return a;
    }
}
