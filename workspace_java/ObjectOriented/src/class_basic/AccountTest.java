package class_basic;

public class AccountTest {
    public static void main(String[] args) {
        //               생성자함수
        //          객체 생성시에만 작성 가능
        Account acc = new Account();
        acc.printAccount();

        Account acc1 = new Account(100000);
        acc1.printAccount();


    }
}
