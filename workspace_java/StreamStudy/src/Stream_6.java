import java.util.Arrays;
import java.util.List;

public class Stream_6 {
    public static void main(String[] args) {

        List<String> fruitList = Arrays.asList("Apple", "Orange", "Kiwi");

        //Function<T> -> R apply(T t)
        //BinaryFunction<T> -> R apply(T t, T t)
        //Operator<T> -> T apply(T t)
        //BinaryOperator<T> -> T apply(T t, T t)
        String data = fruitList.stream()
                .reduce("" , (a, b) ->  a.length() > b.length() ? a : b);
                //reduce 의 첫번째 매개변수 : 리스트의 0번째 요소 추가
                //reduce 의 두번째 배개변수 :  
        System.out.println(data);



    }
}
