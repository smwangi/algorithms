import javax.naming.Name;
import java.util.ArrayList;
import java.util.Collections;

public class StudentComparatorTest {
    public static void main(String[] args) {
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student(101,"sam",23));
        arrayList.add(new Student(106,"wan",27));
        arrayList.add(new Student(105,"mwaz",21));

        System.out.println("Sorting by Name");
        //use name comparator
        Collections.sort(arrayList,new NameComparator());
        arrayList.forEach(x -> System.out.println(x.rollNo+" "+x.name+" "+ x.age));


        System.out.println("\nSorting by Age");
        Collections.sort(arrayList,new AgeComparator());
        arrayList.forEach(x -> System.out.println(x.rollNo+" "+x.name+" "+x.age));
    }
}
