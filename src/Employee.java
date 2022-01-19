import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employee {

    int id;
    double salary;

    Employee(int id , double salary)
    {
        this.id = id;
        this.salary = salary;
    }


    //5 employees list

    //3rd max salary


    public static void main(String[] args)
    {
        Employee e1 = new Employee(1,1000);
        Employee e2 = new Employee(2,2000);
        Employee e3 = new Employee(3,3000);
        Employee e4 = new Employee(4,4000);
        Employee e5 = new Employee(5,5000);

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);


        //Collections.sort(employeeList() -> e1.salary>e2.salary));



    }

}
