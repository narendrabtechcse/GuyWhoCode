package Java.java7less.serialisation;

public class Person {

    private String name;
    private Integer age;
    private double weight;

    public Person(String name , Integer age, double weight)
    {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }


    public String toString()
    {
        return "name "+name + " , age "+age + ",weight = "+weight;
    }

}
