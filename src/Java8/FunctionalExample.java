package Java8;

public class FunctionalExample {

    public static void main(String[] args) {
        Add interf = (a, b) -> a + b;

        System.out.println(interf.add(5, 6));
    }
}

@FunctionalInterface
interface Add {
    public int add(int a, int b);
}
