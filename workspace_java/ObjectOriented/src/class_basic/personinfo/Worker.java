package class_basic.personinfo;

public class Worker {

    PersonInfo p = new PersonInfo();
    WorkInfo w = new WorkInfo();

    public void setInfo(String name, int age, String addr){
        p.setName(name);
        p.setAge(age);
        p.setAddr(addr);
    }

    public void setWorkInfo(String work, String team, int money){
        w.setWork(work);
        w.setTeam(team);
        w.setMoney(money);
    }

    public void displayWoker(){
        System.out.println("이름 : " + p.getName());
        System.out.println("나이 : " + p.getAge());
        System.out.println("주소 : " + p.getAddr());
        System.out.println("회사명 : " + w.getWork());
        System.out.println("부서명 : " + w.getTeam());
        System.out.println("급여 : " + w.getMoney());

    }

}
