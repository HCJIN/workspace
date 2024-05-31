package 세번째_연산자;

public class 초등산수문제 {
    public static void main(String[] args) {
        int pencils = 534;
        int student = 30;
        int pencilsPerStudent = pencils / student;
        int pencilsLeftStudent = pencils % student;

        System.out.println(pencilsPerStudent);
        System.out.println(pencilsLeftStudent);
    }
}
