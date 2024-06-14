package Interface.student;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        MyStudent s = new MyStudent();

        Student[] students = new Student[5];
        Student s1 = new Student("김",90,80,70);
        Student s2 = new Student("나",80,70,80);
        Student s3 = new Student("박",70,60,90);
        Student s4 = new Student("이",60,50,30);
        Student s5 = new Student("하",50,40,20);

        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
        students[3] = s4;
        students[4] = s5;

        String result = s.getGradeByStudentName(students, "김");
        System.out.println("학생의 점수 등급은 : " + s.getGradeByStudentName(students, "김"));
        System.out.println("학생 점수 등급 : " + result);

        System.out.println("----------------");
        int[] result2 = s.getTotalScoresToArray(students);
        System.out.println(Arrays.toString(result2));

        System.out.println("----------------");

        Student stu = s.getHighScoreStudent(s1, s2);
        System.out.println(stu.getName());
    }
}
