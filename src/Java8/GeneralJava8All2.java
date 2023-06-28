package Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//How to count each element/word from the String ArrayList in Java8?
public class GeneralJava8All2 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");

        Map<String,Long> map = names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);

        //How to find only duplicate elements with its count from the String ArrayList in Java8?

        Map<String,Long> namesCount = names
                .stream()
                .filter(x-> Collections.frequency(names, x)>1)
                .collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting()));
        System.out.println(namesCount);

        //How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?

        Optional.ofNullable(names)
                .orElseGet(Collections::emptyList) // creates empty immutable list: [] in case noteLst is null
                .stream().filter(Objects::nonNull) //loop throgh each object and consider non null objects
                .map(note -> names) // method reference, consider only tag name
                .forEach(System.out::println); // it will print tag names


        //Write a program to print the count of each character in a String?
        String s = "This is Bangalore and its cool";
        Map<String, Long> map1 = Arrays.stream(s.split(""))
                .map(String::toLowerCase)
                .collect(Collectors
                        .groupingBy(str -> str,
                                LinkedHashMap::new, Collectors.counting()));

        System.out.println(map1);

    }

}
