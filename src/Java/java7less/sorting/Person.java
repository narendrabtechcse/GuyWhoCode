package Java.java7less.sorting;

import java.util.Comparator;

public class Person {

    int age;
    double weight;
    String name;

    Person(int age,double weight,String name)
    {
        this.age = age;
        this.weight = weight;
        this.name = name;
    }

    public String toString()
    {
        return "[ "+ name + " , "+age+" , "+weight + "]";
    }
}
