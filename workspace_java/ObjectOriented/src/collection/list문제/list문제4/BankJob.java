package collection.list문제.list문제4;

import java.util.List;
import java.util.Scanner;

public class BankJob {
    ManInfo m = new ManInfo();
    Bank b = new Bank();

    Scanner sc = new Scanner(System.in);

    public BankJob(){}




    public void bankNew(){
        System.out.println("계좌개설을 시작합니다.");
        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("주민등록번호 : ");
        int manNum = sc.nextInt();
        System.out.print("연락처 : ");
        String tell = sc.next();
        System.out.print("계좌번호 : ");
        int bankNum = sc.nextInt();
    }

    public void moneyIn(){
        System.out.print("입금계좌번호 : ");
        int bankNum = sc.nextInt();
        System.out.print("현재 총 예금액은 " + b.getMoney() + "원입니다. 예금액을 입력하세요 : ");
        int money = sc.nextInt();
        b.setMoney(b.getMoney() + money);
        System.out.println("정상 입금되었습니다. 현재 총 예금액은 " + b.getMoney() + "원입니다.");
    }

    public void moneyOut(){
        System.out.print("출금계좌번호 : ");
        int bankNum = sc.nextInt();
        System.out.print("현재 총 예금액은 " +  b.getMoney() + "원입니다. 출금액을 입력하세요 : ");
        int money = sc.nextInt();
        b.setMoney(b.getMoney()-money);
        System.out.println("정상 입금되었습니다. 현재 총 예금액은 " + b.getMoney() + "원입니다.");
    }

    public void moneyInfo(){
        System.out.print("계좌번호 : ");
        int bankNum = sc.nextInt();
        System.out.println("현재 총 예금액은 " + b.getMoney() + "원 입니다.");
    }

    public void info(List<Bank> bank){
        for (int i = 0; i < bank.size(); i++){
            System.out.println("이름 : " + bank.get(i).m.getManNum() + " 주번 : " + bank.get(i).getManNum() + " 연락처 : " + bank.get(i).m.getTell() + " 계좌번호 : " + bank.get(i).getBankNum() + " 예금액 : " + bank.get(i).getMoney());
        }
    }

}
