import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    int rollNo;
    String name;
    int age;

    public static void main(String[] args) {
        ArrayList<ComparableExample> examples = new ArrayList<>();
        examples.add(new ComparableExample(101,"sam",38));
        examples.add(new ComparableExample(102,"wan",37));
        examples.add(new ComparableExample(103,"mwan",36));

        Collections.sort(examples);

        examples.forEach(x -> System.out.println(x.rollNo+" "+x.name+" "+x.age));
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
