package collection.list문제.list문제3;

import java.util.ArrayList;
import java.util.List;

public class StudyClass {
    Student stu = new Student();
    List<Student> students = new ArrayList<>();
    private String className;
    private String tName;

    public StudyClass(){

    }
    public StudyClass(Student stu, String className, String tName){
        this.stu = stu;
        this.className = className;
        this.tName = tName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTname() {
        return tName;
    }

    public void setTname(String tName) {
        this.tName = tName;
    }


    public void infoAll(List<Student> students){
        for ( Student stu : students){
            System.out.println(stu.toString());
        }
    }

    public double avgScore(List<Student> students){
        int sum = 0;
        double avg = 0;
        for(int i = 0; i < students.size(); i++){
            sum = sum + students.get(i).getScore();
        }
        avg = sum / (double)students.size();
        return avg;
    }

    public Student bestStudent(List<Student> students){
        Student best = null;
        int max = 0;
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getScore() >= max){
                best = students.get(i);
                max = students.get(i).getScore();
            }
        }
        return best;
    }









}
