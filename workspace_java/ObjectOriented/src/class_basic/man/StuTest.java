package class_basic.man;


//배열 + 클래스
public class StuTest {
    public static void main(String[] args) {
        //학생을 5명 저장할 수 있는 배열 생성
        Student[] students = new Student[5];

        //배열에 저장할 학생 객체 생성
        Student  s1 = new Student("김",20,80);
        Student  s2 = new Student("나",21,70);
        Student  s3 = new Student("박",22,75);
        Student  s4 = new Student("이",23,95);
        Student  s5 = new Student("하",24,100);

        //배열 0번째 요소에 학생 s1 저장
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
        students[3] = s4;
        students[4] = s5;

        //1. 배열에 저장된 모든 학생의 이름, 나이, 점수를 출력
        for (int i = 0; i<students.length; i++){
            System.out.println("-----------");
            students[i].print();
        }

//        1번 문제를 for-each문으로 해결
        for( Student s : students){
            System.out.println("------------");
            s.print();
        }

        //2. 배열에 저장된 학생 중 점수가 80점 이상인 학생의 이름 나이 점수 출력
        for (int i = 0; i<students.length; i++){
            if (students[i].getScore() >= 80){
                System.out.println("-----------");
                students[i].print();
            }
        }

//        3번 문제 이름이 '박'인 학생을 찾아 해당 학생의 나이를 10으로 변경
        for (int i = 0; i<students.length; i++){
            if (students[i].getName().equals("박")){
                students[i].setAge(10);
                students[i].print();
            }
        }

        for (Student s : students){
            if (s.getName().equals("박")){
                s.setAge(10);
                s.print();
            }
        }










    }
}
