package collection.list문제.list문제1;

import java.util.ArrayList;
import java.util.List;

public class TestStudent {

    public static void main(String[] args) {
        List<Student> student = new ArrayList<>();

        Student stu1 = new Student();
        Student stu2 = new Student();
        Student stu3 = new Student();

        stu1.setName("하나둘");
        stu1.setKoScore(30);
        stu1.setMathScore(20);
        stu1.setEngScore(70);
        stu1.setTotalScore(stu1.getKoScore() + stu1.getMathScore() + stu1.getEngScore());
        stu2.setName("셋넷다섯");
        stu2.setKoScore(60);
        stu2.setMathScore(90);
        stu2.setEngScore(100);
        stu2.setTotalScore(stu2.getKoScore() + stu2.getMathScore() + stu2.getEngScore());
        stu3.setName("여섯일곱");
        stu3.setKoScore(40);
        stu3.setMathScore(90);
        stu3.setEngScore(75);
        stu3.setTotalScore(stu3.getKoScore() + stu3.getMathScore() + stu3.getEngScore());

        student.add(stu1);
        student.add(stu2);
        student.add(stu3);

        //문제 9 - 1
        for (int i = 0; i < student.size(); i++){
            System.out.println(student.get(i));
        }

        System.out.println("------------------------------");

        //문제 9 - 2
        for (int i = 0; i < student.size(); i++){
            if (student.get(i).getTotalScore() >= 150){
                System.out.println(student.get(i));
            }
        }

        System.out.println("------------------------------");

        //문제 9 - 3
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < student.size(); i++){
            sum = sum + student.get(i).getTotalScore();
            avg = sum / (double)student.size();
        }
        System.out.println(avg);

        System.out.println("------------------------------");

        //문제 9 - 4
        Student maxStudent = null;
        int max = 0;
        for (int i = 0; i < student.size(); i++){
            if (student.get(i).getTotalScore() >= max){
                max = student.get(i).getTotalScore();
                maxStudent = student.get(i);
            }
        }
        System.out.println(maxStudent);

    }


}
