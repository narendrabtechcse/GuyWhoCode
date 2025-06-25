package Java8.Consumer;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> cm = f->{
            System.out.println(f);
        };

        cm.accept("Narendra");
    }
}
