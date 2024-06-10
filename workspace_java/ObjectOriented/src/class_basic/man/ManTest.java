package class_basic.man;

public class ManTest {
    public static void main(String[] args) {
        Man man = new Man("헝",20,"울산");

        man.setName("kim");
        System.out.println(man.getName());
        man.printMan();


    }
}
