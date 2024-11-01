package 여섯째_배열.심화문제;

public class 심화문제_2 {
    public static void main(String[] args) {
        int[] arr = new int[10];

        int max = 0;
        int min = 10000;


        for (int i = 0; i < arr.length; i++){
            int rand = (int) (Math.random()*100);
            arr[i] = rand;
            System.out.println(arr[i]);
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("max : " + max);
        System.out.println("min : " + min);


    }
}
