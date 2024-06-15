package collection.list문제.list문제4;

public class ManInfo {
    private String manNum;
    private int num;
    private String tell;
    private int bankNum;

    public ManInfo(){

    }

    public ManInfo(String manNum, String tell, int bankNum){
        this.bankNum = bankNum;
        this.manNum = manNum;
        this.tell = tell;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getManNum() {
        return manNum;
    }

    public void setManNum(String manNum) {
        this.manNum = manNum;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public int getBankNum() {
        return bankNum;
    }

    public void setBankNum(int bankNum) {
        this.bankNum = bankNum;
    }
}
