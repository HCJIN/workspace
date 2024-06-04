package 여섯째_배열.심화문제;

public class 심화문제_4 {
    public static void main(String[] args) {
        int[] arr = new int[99];


        for (int i = 0; i < arr.length; i++){
            arr[i] = i+1;

            int num = arr[i];
            int cnt = 0;
            if(num / 10 == 3 && num / 10 == 6 && num / 10 == 9){
                cnt++;
            }
            if(num % 10 == 3 && num % 10 == 6 && num % 10 == 9){
                cnt++;
            }
            if (cnt == 0){
                System.out.println(num + " ");
            }else if(cnt == 1){
                System.out.println(num + "박수 한번");
            }else if(cnt == 2){
                System.out.println(num + "박수 두번");
            }
        }
    }
}
