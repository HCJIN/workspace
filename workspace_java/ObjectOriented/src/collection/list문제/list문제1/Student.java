package collection.list문제.list문제1;

public class Student {

    private String name;
    private int koScore;
    private int mathScore;
    private int engScore;
    private int totalScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKoScore() {
        return koScore;
    }

    public void setKoScore(int koScore) {
        this.koScore = koScore;
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

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", koScore=" + koScore +
                ", mathScore=" + mathScore +
                ", engScore=" + engScore +
                ", totalScore=" + totalScore +
                '}';
    }
}
