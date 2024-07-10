package test;

public class MathTest {
    public static void main(String[] args) {

        MathUtilImpl test = new MathUtilImpl();

        System.out.println((test.isEven(6 , 4 ,10 )));

        System.out.println(test.getSumFromOne(10));

        int[] b = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(test.getArraySum(b));


    }
}
