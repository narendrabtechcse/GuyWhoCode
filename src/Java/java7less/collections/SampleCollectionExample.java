package Java.java7less.collections;

import java.util.*;
import java.util.stream.Collectors;

public class SampleCollectionExample {

    public static void main(String[] args) {
        Collection collection = null;

        collection = new ArrayList<Integer>();

        //add values to collection
        collection.add(10);
        collection.add(20);
        collection.add(30);
        collection.add(5);
        collection.add(8);

        //printing the collection
        System.out.println(collection);

        //check whether 30 is present inside my collection or not.
        boolean isPresent = collection.contains(50);

        System.out.println(isPresent);

        Arrays.sort(collection.toArray());

        //find the minimum or maximum value present inside the collection
        System.out.println(collection.stream().count());

        //Arrays.sort(collection.toArray());

        System.out.println("After sorting the collection : "+ collection);


    }

}
