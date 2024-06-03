package 다섯째_반복문.While.반복문_2;

public class 반복문_3 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 300; i++){
            sum = sum + i;
            System.out.println(sum);
            System.out.println(sum - 299);
        }
    }
}
