package collection.list문제.list문제2;

import java.util.List;
import java.util.Scanner;

public class EmpService {
    private int manNum;
    private String name;
    private String teamName;
    private int tell;
    private int money;

    public EmpService(){

    }

    public EmpService(int manNum, String name, String teamName, int tell, int money){
        this.manNum = manNum;
        this.name = name;
        this.teamName = teamName;
        this.tell = tell;
        this.money = money;
    }

    public int getManNum() {
        return manNum;
    }

    public void setManNum(int manNum) {
        this.manNum = manNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTell() {
        return tell;
    }

    public void setTell(int tell) {
        this.tell = tell;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void login(int manNum, int tell){
        if (this.manNum == manNum){
            if (this.tell == tell){
                System.out.println("로그인이 완료되었습니다");
                System.out.println("'" + this.name + "'님 반갑습니다." );
            }else{
                System.out.println("사번 혹은 비밀번호가 일치하지 않습니다.");
            }
        }
    }

    public void money(List<EmpService> employees){
        Scanner sc = new Scanner(System.in);
        System.out.print("부서명 : ");
        String team = sc.next();
        int sum = 0;
        int cnt = 0;
        System.out.println("==" + team +" 월급 현황==");
        for (EmpService emp : employees){
            if (emp.getTeamName().equals(team)){
                System.out.println("이름 : " + emp.getName() + " 월급 : " + emp.getMoney());
                sum += emp.getMoney();
                cnt++;
            }
        }

        if (cnt > 0) {
            double avg = (double) sum / cnt;
            System.out.println(team + " 부서의 월급 총액은 " + sum + "원이며, 평균 급여는 " + avg + "원입니다.");
        } else {
            System.out.println(team + " 부서에 해당하는 직원이 없습니다.");
        }
    }

    public void moneyUp(List<EmpService> employees){
        Scanner sc = new Scanner(System.in);
        System.out.print("부서명 : ");
        String team = sc.next();
        System.out.print("인상급여 : ");
        int upMoney = sc.nextInt();
        System.out.println(team + " 각 사원의 급여가 각각 " + upMoney + "원씩 인상됩니다.");
        System.out.println("==월급 인상 후 " + team + "부 월급 현황==");
        for (EmpService emp : employees){
            if (emp.getTeamName().equals(team)){
                System.out.println("이름 : " + emp.getName() + " 월급 : " + (emp.getMoney()+upMoney));
            }
        }
    }













}
