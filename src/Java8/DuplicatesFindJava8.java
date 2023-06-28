package Java8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//How to find duplicate elements in a given integers list in java using Stream functions?
public class DuplicatesFindJava8 {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        for(int i=0;i<10;i++)
            list1.add(i);

        for(int i=2;i<6;i++)
            list1.add(i);

        Set<Integer> set = new HashSet<>();

        list1.stream().filter(n->!set.add(n)).forEach(System.out::println);

    }
}
