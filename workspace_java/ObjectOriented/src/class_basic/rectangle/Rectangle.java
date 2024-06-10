package class_basic.rectangle;

public class Rectangle {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(){
        x1 = 0;
        x2 = 0;
        y1 = 0;
        y2 = 0;
    }

    public Rectangle(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public void set(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public int square(){
        return x1 * y1;
    }

    public void show(){
        System.out.println("x 좌표 : " + x1 + x2);
        System.out.println("y 좌표 : " + y1 + y2);
    }


}
