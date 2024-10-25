import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

//중간 연산 : filter(), map(), mapToInt()
//최종연산 : sum(), forEach(), collect(), count(), [average(), min(), max()], reduce()
public class Stream_5 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5);

        int sum = list.stream().mapToInt(num -> num).sum();
        long count = list.stream().mapToInt(num -> num).count();
        OptionalInt min = list.stream().mapToInt(num -> num).min();
        System.out.println(sum);
        System.out.println(count);
        System.out.println(min.getAsInt());
        min.ifPresent( n -> System.out.println(n));



    }
}
