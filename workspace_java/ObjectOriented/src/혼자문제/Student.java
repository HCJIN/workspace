package 혼자문제;

public class Student {

    public static void main(String[] args) {

        Student stu = new Student();

        stu.setStuClass("개발");
        stu.setStuClass("개발");


    }

    private String stuClass;
    private int stuName;

    public int getStuName() {
        return stuName;
    }

    public void setStuName(int stuName) {
        this.stuName = stuName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }
}
