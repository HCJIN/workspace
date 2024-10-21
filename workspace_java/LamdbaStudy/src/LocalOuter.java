public class LocalOuter {

    private String content;

    public LocalOuter(String content){
        this.content = content;
    }

    public Printable getPrinter(){
        //Printable 인터페이스의 객체 생성
        // 1) 인터페이스만으로는 객체 생성 불가
        // -> 인터페이스를 구현한 클래스를 먼저 생성
        // -> 해당 크래스에 대한 객체 생성
        //MyPrinter p = new MyPrinter();
        //Printable 인터페이스를 구현한 클래스

        //------ 로컬 이너 클래스 ------//
        class MyPrinter implements Printable{
            public void print() {
                System.out.println("프린터 실행 ~ ");
            }
        }

        Printable p = new MyPrinter();
        //------ 로컬 이너 클래스 끝 ------//

        //------로컬 이너 클래스 -> 익명 이너 클래스 변환 ------//
        Printable p1 = new Printable() {
            public void print() {
                System.out.println(111);
            }
        };
        //------로컬 이너 클래스 -> 익명 이너 클래스 변환 끝! ------//

        //------ 익명 -> 람다로의 변환 ------//
        Printable p2 = () -> { System.out.println(111); };
        //------ 익명 -> 람다로의 변환 끝! ------//

        //생성한 객체를 리턴
        return p;
    }


}

