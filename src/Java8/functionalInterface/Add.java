package Java8.functionalInterface;

public interface Add {
    public void add(int a , int b);
}

abstract class demo implements Add{

    public static void main(String[] args) {
        Add add = (a,b) -> System.out.println(a+b);
        add.add(10,20);
    }
}
