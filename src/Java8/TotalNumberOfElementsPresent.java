package Java8;

import java.util.ArrayList;
import java.util.List;

//Given a list of integers, find the total number of elements present in the list using Stream functions?
public class TotalNumberOfElementsPresent {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            list1.add(i+1);
        }

        long count =  list1.stream().count();
        System.out.println(count);
    }

}
