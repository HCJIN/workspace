package 다섯째_반복문.While.반복문_1;

public class While문제12 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++){
            if (i % 3 ==0){
                sum++;
            }
        }
        System.out.println("3의 배수의 총 개수 : " +sum);
    }
}
