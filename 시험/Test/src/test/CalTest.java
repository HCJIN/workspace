package test;

public class CalTest {
    public static void main(String[] args) {
        Calculate cal = new Calculate();

        cal.setNumber(1,5);
        System.out.println(cal.getSum());
        System.out.println(cal.getMax());
        System.out.println(cal.getAvg());



    }
}
