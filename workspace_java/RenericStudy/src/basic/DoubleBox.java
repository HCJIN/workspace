package basic;

//보편적인 제네릭 탕비 선언 시 사용하는 문자
// T - type
// E - element
// K - key
// V - value
// N - number
public class DoubleBox<K, V> {
    private K left;
    private V right;

    public void aa(){
        DoubleBox<String, Integer> a = new DoubleBox<>();
    }
}
