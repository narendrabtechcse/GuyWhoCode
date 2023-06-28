package Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
public class ListToMap {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("John", 25),
                new Person("Jane", 30),
                new Person("John", 35),
                new Person("Alice", 28),
                new Person("Bob", 40)
        );

        Map<String, Person> sortedMap = persons.stream()
                .collect(Collectors.toMap(
                        Person::getName,
                        Function.identity(),
                        (person1, person2) -> {
                            // Resolve conflict for duplicate keys
                            // In this example, choose the person with higher age
                            return person1.getAge() > person2.getAge() ? person1 : person2;
                        },
                        TreeMap::new
                ));

        System.out.println(sortedMap);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

