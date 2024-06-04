package 여섯째_배열.심화문제;

public class 심화문제_3 {
    public static void main(String[] args) {
        int max = 0;
        int[] array = {1,5,3,8,2};

        for (int i = 0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        System.out.println("max : " + max);
    }
}
