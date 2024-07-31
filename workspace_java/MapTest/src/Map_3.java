import java.util.HashMap;
import java.util.Map;

public class Map_3 {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("1","1-0-0");
        map.put("2", 100);
        map.put("3", 10);
        map.put("4", 10.5);
        map.put("5", new Student(1, "dd"));

    }
}
