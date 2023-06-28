package Java8;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

//Given a String, find the first non-repeated character in it using Stream functions?
public class FirstNonRepeatedJava8 {

    public static void main(String[] args) {

        String input = "avaJ articles are Awesome";

        Character ch = input.chars().mapToObj(s->Character.toLowerCase(Character.valueOf((char)s))).collect(Collectors.groupingBy(Function.identity()
        , LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()==1L).map(entry->entry.getKey()).findFirst().get();

        System.out.println(ch);
    }

}
