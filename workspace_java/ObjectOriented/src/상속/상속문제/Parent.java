package 상속.상속문제;

public class Parent {
    public String nation;

    public  Parent(){
        this("대한민국");
        System.out.println("parent() call");
    }

    public  Parent(String nation){
        this.nation = nation;
        System.out.println("Parent(String nation) call");
    }
}
