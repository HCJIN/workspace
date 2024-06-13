package Interface;

public class LgTv implements Tv {

    public void turnOn(){
        System.out.println("엘지티비 - 전원 켬");
    }
    public void turnOff(){
        System.out.println("엘지티비  - 전원 끔");
    }
    public void volumeUp(){
        System.out.println("엘지티비 - 소리 올림");
    }
    public void volumeDown(){
        System.out.println("엘지티비 - 소리 내림");
    }
}
