package Java.java7less.sorting;


import java.util.Arrays;

public class Manager5 {

    public static void main(String[] args) {
        Person x[] = {
                new Person(20,45.09,"hello"),
                new Person(10,65.09,"abc"),
                new Person(2,55.09,"xyz"),
                new Person(15,95.09,"test")};

        System.out.println(Arrays.toString(x));

        Arrays.sort(x,new SortBasedOnAge());

        System.out.println(Arrays.toString(x));

        Arrays.sort(x,new SortBasedOnWeight());

        System.out.println(Arrays.toString(x));

        Arrays.sort(x,new SortBasedOnName());

        System.out.println(Arrays.toString(x));

     }
}
