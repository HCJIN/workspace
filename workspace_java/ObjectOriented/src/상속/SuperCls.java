package 상속;

public class SuperCls {

//    public SuperCls(){
//
//    }
    public SuperCls(int a){

    }
    public SuperCls(String a, int b){

    }
}

class Subcls extends SuperCls{
    public Subcls(){
        super(5);
    }
}
