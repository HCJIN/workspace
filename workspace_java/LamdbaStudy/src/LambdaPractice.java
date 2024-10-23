public interface LambdaPractice {
    void printName();
}

interface LambdaPractice1 {
    void printName(String name);
}

interface LambdaPractice2 {
    void printName(String name, int age);
}

interface LambdaPractice3 {
    int getData();
}

interface LambdaPractice4 {
    int getResult(int a, int b);
}

//람다식 인터페이스를 알리는 어노테이션
//제네릭 활용
@FunctionalInterface
interface LambdaPractice5<T> {
    T getResult(T a, T b);
}

@FunctionalInterface
interface LambdaPractice6<T, R> {
    R getResult(T a, T b);
}

