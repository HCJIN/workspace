package Interface.student;

public class MyStudent implements StudentUtil{
    public static void main(String[] args) {
        Student s1 = new Student("김",80,90,100);
        Student s2 = new Student("나",70,20,10);
        Student s3 = new Student("박",67,60,70);
        Student s4 = new Student("이",23,40,90);

        Student[] sarr = new Student[4];

        sarr[0] = s1;
        sarr[1] = s2;
        sarr[2] = s3;
        sarr[3] = s4;

        //--첫번째 메소드 --
        //메소드명 : getGradeByStudentName
        //첫번째 매개변수로 받은 다수의 학생중
        //두번째 매개변수로 받은 이름을 가진 학생의 점수등급을 리턴.
        //단, 전달받은 이름을 가진 학생이 없다면 점수등급은 "등급없음"이 된다.
        //점수등급
        // 90 <= 평균점수 <= 100 : "A"등급
        // 80 <= 평균점수 <= 89 : "B"등급
        // 70 <= 평균점수 <= 79 : "C"등급
        // 70 > 평균점수 : "D"등급

    }
    @Override
    public String getGradeByStudentName(String[] student, String name) {

    }
    //--두번째 메소드--
    //메소드명 : getTotalScoresToArray
    //매개변수로 받은 다수의 학생들의 총점을 배열로 리턴

    @Override
    public int[] getTotalScoresToArray(int korScore, int mathScore, int engScore) {
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++){
            arr[i] =
        }
    }
}
