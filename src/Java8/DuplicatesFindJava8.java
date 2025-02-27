package Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//How to find duplicate elements in a given integers list in java using Stream functions?
public class DuplicatesFindJava8 {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        for(int i=0;i<10;i++)
            list1.add(i);

        for(int i=2;i<6;i++)
            list1.add(i);

        Set<Integer> set = new HashSet<>();

        //list1.stream().filter(n->!set.add(n)).forEach(System.out::println);

        list1.stream().distinct().collect(Collectors.toList()).forEach(System.out::print);

        //count of each element in an array
        list1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).forEach((key, count) -> System.out.println(key + " -> " + count));

        //char count of the string
        "narendrakumaragrawal".chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).forEach((key, count) -> System.out.println(key + " -> " + count));

        System.out.println("Max : " + list1.stream().max(Comparator.naturalOrder()).get());
        System.out.println("Min : " +list1.stream().min(Comparator.naturalOrder()).get());

        //Print mulitple of 5 from the list
        list1.stream().filter(i->i%5==0).forEach(System.out::println);
    }
}
