package Interface.student;


import object.Person;

public class Student{

    private String name;
    private int korScore;
    private int mathScore;
    private int engScore;

    public Student(String name, int korScore, int mathScore, int engScore) {
        this.name = name;
        this.korScore = korScore;
        this.mathScore = mathScore;
        this.engScore = engScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKorScore() {
        return korScore;
    }

    public void setKorScore(int korScore) {
        this.korScore = korScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

}
