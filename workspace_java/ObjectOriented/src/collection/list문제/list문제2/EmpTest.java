package collection.list문제.list문제2;

import java.util.ArrayList;
import java.util.List;

public class EmpTest {
    public static void main(String[] args) {
        EmpService e = new EmpService();
        EmpService e1 = new EmpService(1001,"졸리다","개발",1234,100000);
        EmpService e2 = new EmpService(1002,"잠온다","개발",1111,130000);

        List<EmpService> develope = new ArrayList<>();
        develope.add(e1);
        develope.add(e2);

        e1.login(1001,12234);

        e.money(develope);
        e.moneyUp(develope);



    }
}
