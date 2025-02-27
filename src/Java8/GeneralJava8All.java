package Java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeneralJava8All {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list1.add(i);
        }

        //Given a list of integers, sort all the values present in it using Stream functions?
        list1.stream().sorted().forEach(System.out::println);

        //Given a list of integers, sort all the values present in it in descending order using Stream functions?
        list1.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

        //Given an integer array nums, return true if any value appears at least twice in the array,
        // and return false if every element is distinct.
        Set<Integer> set = new HashSet<>(list1);
        if (set.size() == list1.size()) {
            System.out.println("false");
        } else
            System.out.println("true");


        //How will you get the current date and time using Java 8 Date and Time API?
        System.out.println("Current Local Date: " + java.time.LocalDate.now());
        //Used LocalDate API to get the date
        System.out.println("Current Local Time: " + java.time.LocalTime.now());
        //Used LocalTime API to get the time
        System.out.println("Current Local Date and Time: " + java.time.LocalDateTime.now());
        //Used LocalDateTime API to get both date and time


        //Write a Java 8 program to concatenate two Streams?
        List<String> list2 = Arrays.asList("Java", "8");
        List<String> list3 = Arrays.asList("explained", "through", "programs");

        // Concatenated the list2 and list3 by converting them into Stream
        Stream<String> concatStream = Stream.concat(list2.stream(), list3.stream());

        // Printed the Concatenated Stream
        concatStream.forEach(str -> System.out.print(str + " "));

        // Java 8 program to perform cube on list elements and filter numbers greater than 50.

        list1.stream().map(i -> i * i * i).filter(j -> j > 50).forEach(System.out::println);

        //How to use map to convert object into Uppercase in Java 8?
        List<String> upperCaseList3 = list3.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseList3);
    }
}

