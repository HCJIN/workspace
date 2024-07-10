package test;

public class BankTest {
    public static void main(String[] args) {
        Bank bn = new Bank();

        System.out.println(bn.info("1111-1115","신사임당"));
        System.out.println(bn.money(20000));
    }
}
