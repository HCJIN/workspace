package class_basic.member;

public class MemberTest {
    public static void main(String[] args) {
        Member m1 = new Member();

        m1.setName("아무개");
        m1.setId("n u l l ");
        m1.setPassword("일이삼사");
        m1.setAge(17);

        m1.memberInfo();

    }
}
