package Interface.student;

//1. 아래 요구에 맞는 추상메소드 정의
//2. 완성한 인터페이스를 구현한 클래스 생성(MyStudent)
//3. MyStudent 클래스에서 인터페이스의 메소드 구현
public interface StudentUtil {

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

    String getGradeByStudentName(String[] student, String name);

    //--두번째 메소드--
    //메소드명 : getTotalScoresToArray
    //매개변수로 받은 다수의 학생들의 총점을 배열로 리턴

    int[] getTotalScoresToArray(int[] korScore, int[] mathScore, int[] engScore);

    //--세번째 메소드--
    //메소드명 : getHighScoreStudent
    //매개변수로 두 명의 학생이 전달된다.
    //전달된 두 학생 중 총점이 높은 학생 객체를 리턴.
    //단, 전달된 두 학생의 총점이 같은 경우는 없다고 가정.



}
