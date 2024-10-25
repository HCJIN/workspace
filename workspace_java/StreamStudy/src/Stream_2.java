import java.util.ArrayList;
import java.util.List;

public class Stream_2 {
    public static void main(String[] args) {
        //list.stream().filter().sum();

        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3);

        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("김자바", 80));
        list1.add(new Student("박자바", 70));
        list1.add(new Student("이자바", 100));

        list1.stream()
                .filter( s -> s.getScore() >= 80)
                .forEach( s -> System.out.println(s));







    }
}
