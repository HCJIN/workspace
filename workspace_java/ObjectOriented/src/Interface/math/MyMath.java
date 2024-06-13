package Interface.math;

public class MyMath implements MathUtil{

    //매개변수로 받은 두 수 중 작은 수를 리턴
    @Override
    public int getMin(int a, int b) {
        if (a > b){
            return b;
        }else {
            return a;
        }
    }

    //매개변수로 받은 반지름을 가진 원의 둘레 리턴
    //단, 매개변수로 들어온 반지름이 음수라면 둘레는 0이 되어야함.
    @Override
    public double getCircleArea(int radius) {
        double rad = 0;
        if (radius > 0){
            rad = 2 * 3.14 * (double)radius;
        }else if (radius < 0){
            rad = 0;
        }
        return rad;
    }

    //첫번째 매개변수로 받은 수의 n제곱 값을 리턴
    //첫번째 매개변수 : 3
    //두번쨰 매개변수 : 4
    // 결과 3 * 3 * 3 * 3
    @Override
    public int getMultiple(int num1, int n) {
        int result = 1;
        for (int i = 0; i < n; i++){
            result = result * num1;
        }
        return result;
    }
}
