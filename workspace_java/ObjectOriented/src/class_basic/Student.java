package class_basic;

public class Student {

    String name;
    int age;
    int score;

    //매개변수로 전달된 문자열로 name 값을 변경하는 메소드
    public void change(String str){
        name = str;
    }

    //나이를 변경하는 메소드
    public void setAge(int age1){
        age = age1;
    }


    public void introduce(){
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("점수 : " + score);
    }
}
