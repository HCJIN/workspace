package IF_문제;

public class If문제_1 {
    public static void main(String[] args) {
        // 1번문제
        int a = 53;
        int b = 50;
        if(a + b > 50){
            System.out.println("두 수의 합이 50보다 큽니다.");
        }else{
            System.out.println("두 수의 합이 50보다 작습니다.");
        }
        System.out.println("----------1번문제 끝-------------");

        // 2번문제
        if( a % 2 == 0){
            System.out.println("짝수입니다.");
        }else{
            System.out.println("홀수입니다.");
        }
        System.out.println("----------2번문제 끝-------------");

        //3번문제
        if(a > b){
            System.out.println("A가 큽니다");
        }else if (a < b) {
            System.out.println("B가 큽니다");
        }else{
            System.out.println("같습니다");
        }
        System.out.println("----------3번문제 끝-------------");

        //4번문제
        if(a % 3 == 0){
            System.out.println("3의배수 입니다.");
        }else{
            System.out.println("응 아니야 ^^");
        }
        System.out.println("----------4번문제 끝-------------");

        //5번문제
        String grade;
        if(90 < a && a <= 100){
            grade="A";
        }else if(80 < a && a <= 90){
            grade="B";
        }else{
            grade="C";
        }
        System.out.println("학점은 : " + grade);
        System.out.println("----------5번문제 끝-------------");

        //6번문제
        if(a % 5 == 0){

        }else{
            System.out.println("5의 배수를 입력하세요");
        }
        System.out.println("----------6번문제 끝-------------");
    }
}
