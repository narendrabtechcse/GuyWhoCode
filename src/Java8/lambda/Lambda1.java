package Java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda1 {
    public static void main(String[] args) {

        /*
        BiConsumer<Integer, Integer> printSum = (a, b) -> System.out.println(a + b);

        printSum.accept(3, 4);

        Consumer<Integer> squares = a -> System.out.println(a * a);

        squares.accept(10);


        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(12);

        list.sort((a, b) -> b.compareTo(a));

        System.out.println(list);

        Collections.sort(list,(a,b)-> a.compareTo(b) );
        System.out.println(list);

         */

       /* Employee e1 = new Employee("ABC", 10000, 1);
        Employee e2 = new Employee("BCD", 11000, 2);
        Employee e3 = new Employee("CDE", 9000, 3);
        Employee e4 = new Employee("DEF", 12000, 5);
        Employee e5 = new Employee("EFG", 6000, 4);

        List<Employee> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);
        empList.add(e5);

        List<Employee> sortedEMpListSalary = empList.stream().sorted((a, b) -> Double.compare(a.getSalary(), b.getSalary())).collect(Collectors.toList());

        for (Employee employee : sortedEMpListSalary) {
            System.out.println(employee.getSalary());
        }

        List<Employee> sortedEMpListName = empList.stream().sorted((a, b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList());

        for (Employee employee : sortedEMpListName) {
            System.out.println(employee.getName());
        }*/

        Predicate<Integer> p = i->(i>10);
        System.out.println(p.test(100));


        System.out.println(p.test(9));
    }
}


class Employee {
    String name;
    long salary;
    long employeeId;

    public Employee(String name, long salary, long employeeId) {
        this.employeeId = employeeId;
        this.salary = salary;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
}
