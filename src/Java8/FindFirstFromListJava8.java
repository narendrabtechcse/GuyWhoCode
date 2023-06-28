package Java8;

import java.util.ArrayList;
import java.util.List;

//Given the list of integers, find the first element of the list using Stream functions?
public class FindFirstFromListJava8 {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        for(int i=0;i<100;i++)
            list1.add(i);

        list1.stream().findFirst().ifPresent(System.out::println);

    }
}
