package collection.list문제.list문제2.강사님2번;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpService {

    //리스트,스캐너 선언
    private List<Emp> empList;
    private Scanner sc;

    //EmpService 생성자 생성
    //empList 리스트 초기화
    //스캐너,사원 초기화
    //리스트에 사원 추가
    public EmpService(){
        sc = new Scanner(System.in);

        empList = new ArrayList<>();

        Emp e1 = new Emp(1001,"너","개발부","1111-1111",200);
        Emp e2 = new Emp(1002,"무","개발부","2222-2222",300);
        Emp e3 = new Emp(1003,"졸","영업부","3333-3333",400);
        Emp e4 = new Emp(1004,"리","영업부","5555-5555",500);
        Emp e5 = new Emp(1005,"다","인사부","7777-7777",600);

        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);
        empList.add(e5);
    }

    //1번문제
    public void login(){
        //사번, 비밀번호가 맞을때까지 무한루프
        boolean isRunning = true; //while 문 반복 변수
        boolean isFind = false; // 일치 하는 값을 찾았는지 확인하는 변수

        while (isRunning){
            System.out.print("사번 : ");
            int empNo = sc.nextInt();
            System.out.print("비밀번호(연락처의 마지막 4자리) : ");
            String pw = sc.next();

            //입력한 사번과 비밀번호 일치 여부 확인 후 무한루프 탈출
            for (Emp e : empList){
                if (e.getEmpNo() == empNo && e.getPw().equals(pw)){
                    isRunning = false;
                    System.out.println("로그인 하였습니다");
                    System.out.println("'" + e.getName() + "'님 반갑습니다.");
                    isFind = true;
//                    break;
                }
//                else{
//                    System.out.println("사번 혹은 비밀번호가 일치하지 않습니다.");
//                    break;
//                }
            }
            //isFind 가 현재 true 이므로 부정일때 출력
            if (!isFind){ // '!' = 부정연산자
                System.out.println("사번 혹은 비밀번호가 일치하지 않습니다.");
            }
        }
    }

    //2번문제
    public void printDeptMoney(){
        System.out.print("부서명 : ");
        String dept = sc.next();
        System.out.println("=="+dept+" 월급 현황==");
        int sum = 0;
        int cnt = 0;
        //부서명과 리스트 부서명이 같은 사람의 내용 출력
        for (int i = 0; i < empList.size(); i++){
            if (empList.get(i).getDept().equals(dept)){
                System.out.println("이름 : " + empList.get(i).getName() + " 월급 : " + empList.get(i).getMoney());
                sum = sum + empList.get(i).getMoney();
                cnt++;
            }
        }
        System.out.println(dept + "서의 월급 총액은 " + sum + "원이며, 평균 급여는 " + (sum / (double)cnt) + "원입니다.");
    }

    //3번문제
    public void increaseMoney(){
        System.out.print("부서명 : ");
        String dept = sc.next();
        System.out.print("인상급여 : ");
        int money = sc.nextInt();

        System.out.println(dept + " 각 사원의 급여가 각각 " + money + "원씩 인상됩니다.");
        System.out.println("==월급 인상 후 " + dept + "월급 현황==");

        //급여 인상 코드
        for (Emp e : empList){
            if(e.getDept().equals(dept)){
                e.setMoney(e.getMoney() + money); // int result = e.getMoney() + money;
                System.out.println("이름 : " + e.getName() + " 월급 : " + e.getMoney());
            }
        }

        //인상된 사원 정보 출력
        for (Emp e : empList){
            if(e.getDept().equals(dept)){
                System.out.println(e);
            }
        }



    }












}
