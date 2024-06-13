package Interface.array;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray ma = new MyArray();
        int[] b = {2,2,4,4,6};
        int[] c = {1,2,3,4,5};
        System.out.println(ma.getTwoArrayAvg(b,c));
        System.out.println(ma.isEvenArray(b));
    }
}
