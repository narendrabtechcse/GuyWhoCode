package Java8;

import java.util.ArrayList;
import java.util.List;

//Given a list of integers, find the maximum value element present in it using Stream functions?
public class MaxValInList {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <20 ; i++) {
            list.add(i);
        }

        int maxVal = list.stream().max(Integer::compare).get();

        System.out.println(maxVal);

    }
}
