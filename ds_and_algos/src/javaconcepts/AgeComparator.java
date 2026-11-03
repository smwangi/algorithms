package javaconcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(101,"sam",38));
        students.add(new Student(102,"wan",37));
        students.add(new Student(103,"mwan",36));

        Collections.sort(students, new AgeComparator());

        students.forEach(x -> System.out.println(x.rollNo+" "+x.name+" "+x.age));
    }

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.age == o2.age)
            return 0;
        else if (o1.age > o2.age)
            return 1;
        else return -1;
    }
}
