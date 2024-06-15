package collection.list문제.list문제4;

public class Bank {

    ManInfo m = new ManInfo();

    private int manNum;
    private int bankNum;
    private int money;

    public Bank(){
        this.money = 10000;
    }

    public Bank(int manNum, int bankNum, int money, String manNum3, String tell){
        m.setManNum(manNum3);
        m.setTell(tell);
        m.setBankNum(bankNum);
        this.money = money;
        this.bankNum = bankNum;
        this.manNum = manNum;

    }

    public int getManNum() {
        return manNum;
    }

    public void setManNum(int manNum) {
        this.manNum = manNum;
    }

    public int getBankNum() {
        return bankNum;
    }

    public void setBankNum(int bankNum) {
        this.bankNum = bankNum;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
