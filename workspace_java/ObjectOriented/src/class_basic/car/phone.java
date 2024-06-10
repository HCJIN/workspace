package class_basic.car;

//접근제한자 : 클래스, 메소드, 맴버변수에서 사용.
//1. public : 프로젝트 내에 존재하면 접근 가능
//2. default : 같은 패키지 내에 있으면 접근 가능
//3. protected : 패스
//4. private : 변수, 메소드가 선언된 클래스 안에서만 접근 가능

//맴버변수에는 무조건 private
//메소드는 무조건 public
public class phone {

    private int price;
    String modelName;
    String brand;

    //생성자
    public phone(){
        this.price = 0;
        this.modelName = "";
    }

    public void setPrice(int price){
        if (price < 0){
            this.price = 0;
        }
        else {
            this.price = price;
        }
    }






}
