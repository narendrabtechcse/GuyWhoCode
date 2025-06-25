package Java8.predicate;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> p = i->(i>9);
        System.out.println(p.test(10));
        System.out.println(p.test(7));
    }
}
