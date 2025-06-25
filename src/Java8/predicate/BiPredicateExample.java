package Java8.predicate;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {
        BiPredicate<Integer,Integer> bFn = (a,b)-> (a>10 && b>20);

        System.out.println(bFn.test(12,34));
        System.out.println(bFn.test(2,34));
        System.out.println(bFn.test(12,4));
        System.out.println(bFn.test(2,3));
    }
}
