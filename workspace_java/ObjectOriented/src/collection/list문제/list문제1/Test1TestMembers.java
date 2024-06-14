package collection.list문제.list문제1;

import java.util.ArrayList;
import java.util.List;

public class Test1TestMembers {

    public static void main(String[] args) {
        Test1_Member m1 = new Test1_Member();
        Test1_Member m2 = new Test1_Member();
        Test1_Member m3 = new Test1_Member();

        m1.setId("java");
        m1.setPassword("111");
        m1.setName("홍");
        m1.setAge(12);

        m2.setId("id2");
        m2.setPassword("222");
        m2.setName("길");
        m2.setAge(15);

        m3.setId("id3");
        m3.setPassword("333");
        m3.setName("동");
        m3.setAge(17);

        List<Test1_Member> tm1 = new ArrayList<>();

        tm1.add(m1);
        tm1.add(m2);
        tm1.add(m3);

        //문제6번
        for (int i = 0; i < tm1.size(); i++){
            System.out.println(tm1.get(i));
        }

        System.out.println("-------------------------");

        //문제7번
        int sum = 0;
        for (int i = 0; i < tm1.size(); i++){
            sum = sum + tm1.get(i).getAge();
        }
        System.out.println(sum);

        System.out.println("-------------------------");

        //문제8번

        int index = 0;
        for (int i = 0; i < tm1.size(); i++){
            if (tm1.get(i).getId().equals("java")){
                index = i;
            }
        }
        tm1.remove(index);
        System.out.println(tm1);
    }

}
