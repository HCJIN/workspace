package test;

public class MemberTest {
    public static void main(String[] args) {
        Member mem = new Member();

        mem.setInfo("자바","java","abcd1234",20);

        mem.showInfo();

        System.out.println(mem.isLogin("java","abcd1234"));
        System.out.println(mem.isLogin("java","abcd"));

    }

}


