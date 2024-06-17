package collection.list문제.list문제2.강사님2번;

public class Emp {
    //사원 정보 선언
    private int empNo;
    private String name;
    private String dept;
    private String tell;
    private int money;

    //Emp 생성자생성 ( 사원 정보 초기화 )
    public Emp(int empNo, String name, String dept, String tell, int money) {
        this.empNo = empNo;
        this.name = name;
        this.dept = dept;
        this.tell = tell;
        this.money = money;
    }

    //getter, setter 생성
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    //사원의 연락처 마지막 4자리 값 리턴
    public  String getPw(){
//        String num = "010-1111-2222";
//        num.substring(5); //111-2222
//        num.substring(1, 4); // 10-
        return tell.substring(5);
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //toString 생성
    @Override
    public String toString() {
        return "EmpService{" +
                "empNo=" + empNo +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", tell='" + tell + '\'' +
                ", money=" + money +
                '}';
    }
}
