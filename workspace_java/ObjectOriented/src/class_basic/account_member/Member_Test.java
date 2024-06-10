package class_basic.account_member;

public class Member_Test {
    public static void main(String[] args) {
        Member m1 = new Member("홍길동", "hong");
        Member m2 = new Member("강자바", "java");

//        m1.setName("자바");
//        m1.setId("java");
//        m1.setPassword("123");

        m1.displayInfo();
        m2.displayInfo();





    }

}
