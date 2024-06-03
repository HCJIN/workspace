package 다섯째_반복문.While.반복문_1;

public class While문제11 {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        while (i <= 100){
            if (i % 3 == 0){
                sum++;
            }
            i++;
        }
        System.out.println("3의 배수인 수의 개수 : " + sum);
    }
}
