package 여섯째_배열.집에서;

public class 문제2_10{
    public static void main(String[] args) {
        int[] a = new int[1];
        a[0] = 5;
        setValue(a);
        System.out.println(a[0]);
    }

    public static void setValue(int[] a) {
        a[0] = a[0] + 5;
    }

}
