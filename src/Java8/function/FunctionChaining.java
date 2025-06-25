package Java8.function;

import java.util.function.Function;

public class FunctionChaining {
    public static void main(String[] args) {
        Function<String,String> f1 = f-> f.toUpperCase();
        Function<String,String> f2 = f->f.substring(0,5);

        System.out.println(f1.andThen(f2).apply("NarendraKumarAgrawal"));

        System.out.println(f1.compose(f2).apply("NarendraKumarAgrawal"));
    }
}
