package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*Given a list of integers, find out all the even numbers that exist in the list using Stream functions?*/
public class EvenNumbersInList {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        for(int i=0;i<100;i++)
        list1.add(i);


       /* List<Integer> list2 = list1.stream().filter(i->i%2==0).collect(Collectors.toList());

        for(int j=0;j<list2.size();j++)
        System.out.println(list2.get(j));

        */

        //using for each
        list1.stream().filter(i->i%2==0).forEach(System.out::println);

        System.out.println("Count : "+list1.stream().filter(i->i%2==0).count());


    }
}
