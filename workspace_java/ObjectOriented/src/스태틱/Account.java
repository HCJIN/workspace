package 스태틱;

//예금 이율 : 7%
public class Account {
    private String accNum; //계좌번호
    private int money; //예금액
    static double iyul; //이율

    static {
        iyul = 7.0;
    }

    public Account(String accNum, int money){
        this.accNum = accNum;
        this.money = money;
//        iyul = 7.0;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNum='" + accNum + '\'' +
                ", money=" + money +
                ", iyul=" + iyul +
                '}';
    }
}
