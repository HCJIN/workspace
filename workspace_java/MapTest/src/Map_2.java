import java.util.HashMap;
import java.util.Map;

public class Map_2 {
    public static void main(String[] args) {
        Student stu1 = new Student(1, "일");
        Student stu2 = new Student(2, "이");
        Student stu3 = new Student(3, "삼");

        Map<Integer, Student> map = new HashMap<>();

        map.put(stu1.getStuNum(), stu1);
        map.put(stu2.getStuNum(), stu2);
        map.put(stu3.getStuNum(), stu3);

        System.out.println(map);

        System.out.println(map.get(2).getStuName());

    }
}
