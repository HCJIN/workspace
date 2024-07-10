package test;

public class MathUtilImpl implements MathUtil{


    @Override
    public boolean isEven(int a, int b, int c) {
        //매개변수로 받은 세 수의 합이 짝수이면서
        //동시에 5의 배수일 경우에만 리턴 true
        boolean result = false;
        int sum = a + b + c;
        if (sum % 2 == 0 && sum % 5 == 0){
            result = true;
        }
        return result;
    }

    @Override
    public int getSumFromOne(int num) {
        //1부터 매개변수로 받은 수까지의 합을 리턴
        int sum = 0;
        for (int i = 1; i <= num; i++){
            sum  = sum + i;
        }

        return sum;
    }

    @Override
    public int getArraySum(int[] arr) {
        //매개변수로 정수형 배열이 들어오면
        //해당 배열의 모든 요소의 합을 리턴
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }

        return sum;
    }
}
