package 상속.상속문제;

class A1 {
    private int x;
    private int y;

    public A1(){
        x = 1;
        y = 1;
    }

    public void disp(){
        System.out.print(" x = " + this.x + " y = " + this.y);
    }

    public A1(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
class B1 extends A1{
    private int x;
    private int y;

    public B1(){
        super();
        this.x = 1;
        this.y = 1;
    }

    public B1(int x){
        super(x, 1);
        this.x = 1;
        this.y = 1;
    }

    public B1(int x, int y){
        super(x, y);
        this.x = 1;
        this.y = 1;
    }

    public B1(int x, int y, int x1){
        super(x, y);
        this.x = x1;
        this.y = 1;
    }

    public B1(int x, int y, int x1, int y1){
        super(x, y);
        this.x = x1;
        this.y = y1;
    }


    public void disp(){
        super.disp();
        System.out.println(" x = " + this.x + " y = " + this.y);
//        System.out.println("x = " + getX() + " y = " + getY() + " x = " + this.x + " y = " + this.y);
    }
}

public class Work {
    public static void main(String[] args) {
        B1 bp = new B1();
        B1 bp1 = new B1(10);
        B1 bp2 = new B1(10,20);
        B1 bp3 = new B1(10,20,30);
        B1 bp4 = new B1(10,20,30,40);

        bp.disp();
        bp1.disp();
        bp2.disp();
        bp3.disp();
        bp4.disp();
    }
}
