package object;

import class_basic.Monitor;

//클래스가 상속을 받고 있지 않다면 자동으로 Object 클래스를 상속 받음.
//모든 클래스는 Object 클래스를 상속 받는다.
public class Tv{
    String modelNumber;

    public void powerOn(){
        System.out.println("전원 시작");
        aaa(5);
        Monitor mm = new Monitor();
        bbb(mm);

        ccc(mm);
    }

    public void ccc(Object obj){

    }

    public void bbb(Monitor m){

    }

    public void aaa(int a){

    }


}

class LgTv extends Tv{

}

class SsTv extends LgTv{

}