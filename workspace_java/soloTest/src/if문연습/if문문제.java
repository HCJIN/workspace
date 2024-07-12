package if문연습;

import java.util.Arrays;

public class if문문제 {
    public static void main(String[] args) {

        int[] num_list = {1,2,3,4,5};
        int[] arr = new int[num_list.length];

        for (int i = 0; i < num_list.length; i++){
            arr[i] += num_list.length - i;
        }
        System.out.println(Arrays.toString(arr));
    }
}
