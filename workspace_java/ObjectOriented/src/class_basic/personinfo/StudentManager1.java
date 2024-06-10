package class_basic.personinfo;

public class StudentManager1 {
    public static void main(String[] args) {
        Student st = new Student();
        st.setInfo("김자바",20,"울산");
        st.setSongjuk(80,70,90);
        st.displayStudentInfo();
    }
}
