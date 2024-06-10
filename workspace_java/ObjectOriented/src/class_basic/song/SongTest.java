package class_basic.song;

public class SongTest {
    public static void main(String[] args) {
        Song s1 = new Song();
        String[] b = {"꿀", "잠", "중"};

        s1.setAll("잠온다","꿀잠","잠1집",2024, b);
        s1.info();
    }
}
