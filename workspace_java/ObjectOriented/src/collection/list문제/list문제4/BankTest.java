package collection.list문제.list문제4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankTest {
    public static void main(String[] args) {


        Bank b1 = new Bank(950427,1234,10000,"홍길동","010-0000-0000");

        List<Bank> bank = new ArrayList<>();

        bank.add(b1);

        BankJob bankJob = new BankJob();
        Scanner sc = new Scanner(System.in);

        boolean result = true;
        while (result){
            System.out.print("1.계좌개설 2.입금 3.출금 4.예금조회 5.계좌해지 6.전체조회 : ");
            int num = sc.nextInt();
            switch (num){
                case 1:
                    bankJob.bankNew();
                    break;
                case 2:
                    bankJob.moneyIn();
                    break;
                case 3:
                    bankJob.moneyOut();
                    break;
                case 4:

                case 5:

                case 6:
                    bankJob.info(bank);
                case 7:
                    result = false;
            }

        }




    }
}
