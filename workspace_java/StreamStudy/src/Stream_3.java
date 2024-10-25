import java.util.Arrays;
import java.util.List;

public class Stream_3 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("box", "robot", "simple");
        list.stream()
                .map( str -> str.length())
                .forEach( ttt -> System.out.println(ttt));

        list.stream()
                .mapToInt(str -> str.length())
                .sum();
        //printAll("a", "b", "c");


    }

    //매개변수로 문자열이 1개, 2개, 3개... 몇개 들어올지 모름
    public static void printAll(String... s){
        Arrays.stream(s).forEach(e -> System.out.println(e));
    }
}
