package class_basic.personinfo;

public class Student {
    PersonInfo p = new PersonInfo();
    Sungjuk s = new Sungjuk();

    public void setInfo(String name, int age, String addr){
        p.setName(name);
        p.setAge(20);
        p.setAddr(addr);
    }
    public void setSongjuk(int ko, int en, int ma){
        s.setKo(ko);
        s.setEn(en);
        s.setMa(ma);
    }

    public void displayStudentInfo(){
        System.out.println("이름 : " + p.getName());
        System.out.println("나이 : " + p.getAge());
        System.out.println("주소 : " + p.getAddr());
        System.out.println("국어점수 : " + s.getKo());
        System.out.println("영어점수 : " + s.getEn());
        System.out.println("수학점수 : " + s.getMa());
        System.out.println("총점 : " + (s.getKo() + s.getEn() + s.getMa()));
        double avg = (s.getKo() + s.getEn() + s.getMa()) / (double)3;
        System.out.println("평균 : " + avg);
    }

}
