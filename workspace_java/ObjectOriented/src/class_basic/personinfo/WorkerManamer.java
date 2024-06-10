package class_basic.personinfo;

public class WorkerManamer {
    public static void main(String[] args) {
        Worker w = new Worker();
        w.setInfo("김자바",20,"울산");
        w.setWorkInfo("삼성","무선사업부",50000);
        w.displayWoker();
    }
}
