package collection.list문제.list문제3;

import java.util.ArrayList;
import java.util.List;

public class SchoolTest {
    public static void main(String[] args) {
        //자바반에 소속될 학생 3명 생성
        Student_1 s1 = new Student_1("배부르다", 17, 90);
        Student_1 s2 = new Student_1("그래서", 18, 85);
        Student_1 s3 = new Student_1("잠온다", 19, 97);

        //자바반에 저장할 학생 List
        List<Student_1> stuList = new ArrayList<>();
        //자바반에 학생 저장
        stuList.add(s1);
        stuList.add(s2);
        stuList.add(s3);

        //자바반
        StudyClass javaClass = new StudyClass("자바반","강_자바", stuList);

        //캐드반에 저장될 학생 3명 생성
        Student_1 s4 = new Student_1("잠와서",20,100);
        Student_1 s5 = new Student_1("졸았따",21,80);
        Student_1 s6 = new Student_1("피곤해",26,90);
        //캐드반 학생들이 저장될 List 생성
        List<Student_1> stuList2 = new ArrayList<>();
        //캐드반에 학생 저장
        stuList2.add(s4);
        stuList2.add(s5);
        stuList2.add(s6);
        //캐드반 객체 생성 + 캐드반에 위에서 만든 캐드반 학생 목록 저장
        StudyClass cadClass = new StudyClass("캐드반", "강_캐드", stuList2);

        //영상반에 저장될 학생 3명 생성
        Student_1 s7 = new Student_1("오늘은",26,100);
        Student_1 s8 = new Student_1("일찍",30,90);
        Student_1 s9 = new Student_1("자야지",23,84);
        //영상반 학생들이 저장될 List 생성
        List<Student_1> stuList3 = new ArrayList<>();
        //영상반에 학생 저장
        stuList3.add(s7);
        stuList3.add(s8);
        stuList3.add(s9);
        //영상반 객체 생성 + 영상반에 위에서 만든 영상반 학생 목록 저장
        StudyClass mediaClass = new StudyClass("영상반", "강_영상", stuList3);

        //교실을 여러개 저장할 수 있는 List 생성
        List<StudyClass> classList = new ArrayList<>();
        classList.add(cadClass);
        classList.add(cadClass);
        classList.add(mediaClass);

        School school = new School(classList);

        //학교 안의 모든 학생의 정보 출력
        for (int i = 0; i < school.getClassList().size(); i++){
            for (int j = 0; j < school.getClassList().get(i).getStuList().size(); j++){
                System.out.println(school.getClassList().get(i).getStuList().get(i));
            }
        }
    }
}
