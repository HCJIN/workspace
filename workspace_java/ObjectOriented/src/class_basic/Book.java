package class_basic;

public class Book {

    //맴버변수
    String title;
    String writer;
    int price;

    //생성자
    public Book(){
        this.title = "";
        this.writer = "";
        this.price = 0;
    }

    public Book(String title, String writer, int price) {
        this.title = title;
        this.writer = writer;
        this.price = price;
    }
}
