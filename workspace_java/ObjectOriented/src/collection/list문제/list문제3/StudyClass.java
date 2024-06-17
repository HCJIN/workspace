package collection.list문제.list문제3;

import java.util.List;

public class StudyClass {
    private String className;
    private String teacher;
    private List<Student_1> stuList;

    public StudyClass(String className, String teacher, List<Student_1> stuList){
        this.className = className;
        this.teacher = teacher;
        this.stuList = stuList;
    }

    //1) 해당 반의 모든 학생의 모든 정보를 출력하는 기능
    public void printStuAll(){
        for (Student_1 stu : stuList){
            System.out.println(stu);
        }
    }

    //2) 해당 반의 평균 성적을 리턴하는 기능
    //3) 해당 반에서 최고 성적을 지닌 학생을 리턴하는 기능

    public List<Student_1> getStuList(){
        return stuList;
    }
}
