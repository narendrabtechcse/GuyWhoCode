package Java8.function;

import javax.swing.text.Style;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StudentGradeUsingFunctions {
    public static void main(String[] args) {

        ArrayList<Student> l = new ArrayList<Student>();
        populate(l);

        Function<Student, String> fn = s -> {
            int marks = s.marks;
            if (marks >= 80) {
                return "A[Dictinction]";
            } else if (marks >= 60) {
                return "B[First Class]";
            } else if (marks >= 50) {
                return "C[Second Class]";
            } else if (marks >= 35) {
                return "D[Third Class]";
            } else {
                return "E[Failed]";
            }
        };

        Function<List<Student>, Integer> sumOfMarks = l1 -> {
            int marks = 0;
            for (Student student : l1) {
                marks += student.marks;
            }
            return marks;
        };

        for (Student s : l) {
            System.out.println("Student Name:" + s.name);
            System.out.println("Student Marks:" + s.marks);
            System.out.println("Student Grade:" + fn.apply(s));
            System.out.println();
        }

        System.out.println("Total marks of the students : " + sumOfMarks.apply(l));
    }

    public static void populate(ArrayList<Student> l) {
        l.add(new Student("Sunny", 100));
        l.add(new Student("Bunny", 65));
        l.add(new Student("Chinny", 55));
        l.add(new Student("Vinny", 45));
        l.add(new Student("Pinny", 25));

    }
}

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;

        this.marks = marks;
    }
}
