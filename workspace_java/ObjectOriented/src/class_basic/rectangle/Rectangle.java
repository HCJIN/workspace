package class_basic.rectangle;

public class Rectangle {
    //사각형을 구성하는 두 점의 좌표
    int x1;
    int y1;
    int x2;
    int y2;

    public Rectangle(){}
    public Rectangle(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void set(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    //사각형 넓이 리턴
    public int square(){
        return (x2-x1) * (y2-y1);
    }

    //좌표 정보, 넓이 출력
    //(1,2), (5,7)
    public void show(){
        System.out.println("( " + x1 + "," + y1 + " ), " + "( " + x2 + "," + y2 + " )");
        System.out.println("사각형의 넓이 : " + square());
    }

    //인자로 전달된 객체 r과 현 객체가 같은 넓이라면 리턴 true
    public boolean equals(Rectangle r){
        if (r.square() == square()){
           return true;
        }else{
            return false;
        }
    }


}
