package 네번째_조건문;

public class IF_4 {
    public static void main(String[] args) {
        int x1 = 5;

        //첫번째 예시
        if(x1 > 3){
            System.out.println(1);
        }
        if(x1 == 5){
            System.out.println(2);
        }
        if(x1 < 10){
            System.out.println(3);
        }

        //두번째 예시
        if(x1 > 3){
            System.out.println(1);
        }
        else if(x1 == 5){
            System.out.println(2);
        }
        else if(x1 < 10){
            System.out.println(3);
        }
    }
}
