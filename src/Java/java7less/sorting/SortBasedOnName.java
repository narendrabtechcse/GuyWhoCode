package Java.java7less.sorting;

import java.util.Comparator;

public class SortBasedOnName implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Person p1 = (Person) o1;
        Person p2 = (Person) o2;

        return p1.name.compareTo(p2.name);
    }
}
