package class_basic;

public class StudentTest {
    public static void main(String[] args) {
        //학생 객체 stu1 생성
        Student stu1 = new Student();

        //stu1 학생의 모든 정보 출력
        System.out.println(stu1.name);

        //stu1 학생의 모든 정보 출력
        stu1.name = "집에가자";
        stu1.age = 8282;
        stu1.score = 8282;

        stu1.introduce();

        System.out.println("-------이름 변경----------");
        stu1.change("더 빨리");

        stu1.introduce();

        System.out.println("-------나이 변경----------");
        //stu1.age = 30;
        stu1.setAge(30);
        stu1.introduce();




    }
}
