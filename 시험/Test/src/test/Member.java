package test;

public class Member {
    private String name;
    private String id;
    private String pw;
    private int age;

    void setInfo(String name, String id, String pw, int age){
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.age = age;
    }

    void showInfo(){
        System.out.println("name = " + name);
        System.out.println("id = " + id);
        System.out.println("pw = " + pw);
        System.out.println("age = " + age);
    }

    boolean isLogin(String id, String pw){
        if (id.equals("java")){
            if (pw.equals("abcd1234")){
                System.out.println("로그인 가능");
                return true;
            }else{
                System.out.println("로그인 불가능");
                return false;
            }
        }else{
            System.out.println("로그인불가능");
            return false;
        }
    }
}
