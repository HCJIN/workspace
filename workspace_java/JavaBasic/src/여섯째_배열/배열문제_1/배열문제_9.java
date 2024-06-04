package 여섯째_배열.배열문제_1;

public class 배열문제_9 {
    public static void main(String[] args) {

        int[] arr = {1, 5, 7};

        int sum = 0;

        for (int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        System.out.println(sum);
    }
}
