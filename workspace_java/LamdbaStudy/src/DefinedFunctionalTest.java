import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DefinedFunctionalTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        DefinedFunctional.printEvenOfList(list);
        DefinedFunctional.printOddOfList(list);
        DefinedFunctional.printSumOfList(list);
        System.out.println();
        System.out.println();

        Predicate<Integer> p = (num) -> num % 2 == 0;
        DefinedFunctional.printOfList(list, p);
        DefinedFunctional.printOfList(list, (num) -> num % 2 != 0);
        DefinedFunctional.printOfList(list, (num) -> num > 3);

        System.out.println("-------------------------");
        //list 에서 짝수만 삭제
//        for(int i = 0; i < list.size(); i++){
//            if(list.get(i) % 2 == 0){
//                list.remove(i);
//                i--;
//            }
//        }

        //위의 코드를 함수형 인터페이스 사용으로 변환
        list.removeIf( num -> num > 2 );
        list.forEach(num -> System.out.println(num));

        //짝수만 삭제됐는지 확인
        for(int e : list){
            System.out.println(e);
        }
        System.out.println("------------------------");

        //Supplier<T> -> T get() 연습
        List<Integer> result = DefinedFunctional.makeIntList(() -> {
            Random rand = new Random();
            return rand.nextInt(50);
        }, 5);
        result.forEach(num -> System.out.print(num + " "));

        System.out.println();
        System.out.println("------------------------");
        //Consumer<T> -> void accept(T t ) 연습
        list.forEach((num) -> System.out.println(num));
        list.forEach( num -> {
            num = num + 5;
        });

        System.out.println("------------------------");

        //Function<T, R> -> R apply(T t) 연습 메서드
        List<String> strList = new ArrayList<>();
        strList.add("하나"); strList.add("둘"); strList.add("셋");

        DefinedFunctional.getIntListFromString( str -> str.length() , strList);



    }
}
