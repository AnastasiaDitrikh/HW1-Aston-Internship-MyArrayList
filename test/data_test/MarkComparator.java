package data_test;

import java.util.Comparator;

public class MarkComparator implements Comparator<Student> {

    @Override
    public int compare(Student st1, Student st2) {
        return Double.compare(st1.getAvgMark(), st2.getAvgMark());
    }
}