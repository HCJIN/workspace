package 상속.상속문제;

public class Test7 {

}

class A{
    private int n;
    public int getN(){
        return n;
    }
    public void setN(int i){
        n = i;
    }
}

class B extends A{
    public String s;
    public int m;
    private char c;
    public void setC(char ch){
        c = ch;
    }
    public char getC(){
        return c;
    }
}

class C extends B{
    public double d;
}
