public class Test3 {
    public static void main(String[] args) {
        int[] arr = {5, 11, 20, 40, 30};

        int max = 0;
        int min = 1000;

        for (int i = 0; i < arr.length; i++){
            if (max < arr[i]){
                max = arr[i];
            }
            if (arr[i] < min){
                min = arr[i];
            }
        }

        System.out.println("가장 큰 값 : " + max);
        System.out.println("가장 작은 값 : " + min);
    }
}
