package collection.list문제.list문제3;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        School sc = new School();
        StudyClass stc = new StudyClass();
        School sh = new School();

        Student stu1 = new Student("가나다",16,90);
        Student stu2 = new Student("라마바",18,70);
        Student stu3 = new Student("사아자",13,88);

        StudyClass stc1 = new StudyClass(stu1,"하늘","강");
        StudyClass stc2 = new StudyClass(stu2,"땅","김");
        StudyClass stc3 = new StudyClass(stu3,"바람","고");

        List<Student> students = new ArrayList<>();
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);

        List<StudyClass> studyClasses = new ArrayList<>();
        studyClasses.add(stc1);
        studyClasses.add(stc2);
        studyClasses.add(stc3);


        sh.classAll(studyClasses, "강");



    }
}
