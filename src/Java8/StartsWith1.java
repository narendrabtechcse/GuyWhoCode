package Java8;


import java.util.ArrayList;
import java.util.List;

//Given a list of integers, find out all the numbers starting with 1 using Stream functions?
public class StartsWith1 {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list1.add(i);
        }

        list1.stream().map(s->s+"").filter(i->i.startsWith("1")).forEach(System.out::println);
    }
}
