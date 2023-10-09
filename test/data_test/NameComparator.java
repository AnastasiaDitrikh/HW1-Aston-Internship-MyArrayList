package data_test;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student st1, Student st2) {
        return st1.getName().compareTo(st2.getName());
    }
}
