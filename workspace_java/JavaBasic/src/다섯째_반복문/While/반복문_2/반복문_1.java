package 다섯째_반복문.While.반복문_2;

public class 반복문_1 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++){
            if (i % 7 == 0 || i % 9 == 0){
                System.out.println(i);
            }
        }
    }
}