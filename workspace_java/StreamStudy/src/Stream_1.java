import javax.lang.model.type.ArrayType;
import java.util.Arrays;

public class Stream_1 {
    public static void main(String[] args) {

        //정수가 저장된 배열에서 짝수의 합을 출력
        int[] arr = {1,2,3,4,5};
        int sum =0;

        for (int e : arr){
            if (e % 2 == 0){
                sum = sum + e;
            }
        }
        System.out.println(sum);

        //정수가 저장된 배열에서 짝수의 합을 출력(스트림 사용)

        //Predicate<T> -> boolean x(T t)
        //IntPredicate -> boolean x(int t)
        //스트림의 마지막은 항상 최종연산으로 끝낸다.
        //최종연산은 마지막에 한 번만 가능
        //중간 연산은 필요 시 여러개 연결 가능
        //중간 연산끼리의 순서는 상관없음
        //중간 연산은 필요할 때만 사용, 최종연산은 반드시 존재해야 함.
        int result = Arrays.stream(arr) // 배열을 스트림화 시킨 것
                .filter( num -> num % 2 == 0) //중간연산
                .sum(); //최종연산

        System.out.println(result);

        int[] arr2 = {2,6,10,1,7,3};

        //스트림을 사용하여 아래 주어진 배열에서
        //짝수이면서 5보다 큰 데이터의 합을 출력
        int result2 = Arrays.stream(arr2)
                .filter( num -> num % 2 == 0)
                .filter( num -> num > 5)
                .sum();

        System.out.println(result2);

        int result3 = Arrays.stream(arr2).sum();






    }
}
