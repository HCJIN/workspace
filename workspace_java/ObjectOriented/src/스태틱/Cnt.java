package 스태틱;

//static : 맴버변수, 메소드에서 사용 가능
//공용변수, 공용메소드를 의미한다.
public class Cnt {
   static int num = 0;

    public Cnt(){
        num++;
        System.out.println(num);
    }
}
