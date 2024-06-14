package Interface.student;

public class MyStudent implements StudentUtil{

    @Override
    public String getGradeByStudentName(Student[] students, String name) {
        String grade = "등급없음";
        for (Student stu : students){
            if (stu.getName().equals(name)){
                double avg = (stu.getKorScore() + stu.getMathScore() + stu.getEngScore()) / 3.0;
                grade = getGradeByAvg(avg);
            }
        }
        return grade;
    }

    //점수에 따라 등급 결정
    public String getGradeByAvg(double avg){
        String grade = "등급없음";
        if (90 <= avg && avg <= 100){
            grade = "A";
        }else if (80 <= avg && avg <= 89){
            grade = "B";
        }else if (70 <= avg && avg <= 79){
            grade = "C";
        }else{
            grade = "D";
        }
        return grade;
    }

    @Override
    public int[] getTotalScoresToArray(Student[] students) {
        //학생들의 총점이 저장될 배열
        int[] totalScores = new int[students.length];

        for (int i = 0; i < students.length; i++){
            totalScores[i] = students[i].getKorScore() + students[i].getMathScore() + students[i].getEngScore();
        }
        return totalScores;
    }

    @Override
    public Student getHighScoreStudent(Student stu1, Student stu2) {
        int Sum1 = stu1.getKorScore()  + stu1.getMathScore() + stu1.getEngScore();
        int Sum2 = stu2.getKorScore()  + stu2.getMathScore() + stu2.getEngScore();

        return Sum1 > Sum2 ? stu1 : stu2;
    }
}
