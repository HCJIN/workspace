package 상속;

//자바에서 다중상속은 가능한가?(부모크래스를 여러개 가질 수 있는가?)
//-> 문법적으로는 불가능, 논리적으로 가능
public class Grand {
    int a;
    protected int d; //해당 클래스 상속받는 자식 클래스 까지
}

class parent1 extends Grand{
    int b;
}

class child1 extends parent1{
    int c;

    public void aaa(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}

