import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//중간 연산 : filter(), map(), mapToInt()
//최종연산 : sum(), forEach(), collect(), count(), [average(), min(), max()], reduce()
public class Sream_4 {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student("김김",20));
        list.add(new Student("홍홍홍",30));
        list.add(new Student("이이이이",40));
        list.add(new Student("박박박박박",50));
        list.add(new Student("최최최최최최",60));

        int sumOfAge = list.stream()
                .filter( s -> s.getName().length() >= 4)
                .mapToInt( s -> s.getScore())
                .sum();
        System.out.println(sumOfAge);

        //중간연산의 결과로 나오는 데이터를 리스트 형태로 저장하는 최종연산
        List<Student> result = list.stream().filter(stu -> stu.getScore() > 30)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
