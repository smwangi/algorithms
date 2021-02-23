import java.util.ArrayList;
import java.util.Collections;

public class ComparableExample implements Comparable<ComparableExample>{

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

    public ComparableExample(int rollNo,String name, int age){
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(ComparableExample obj) {
        if(age == obj.age)
            return 0;
        else if (age > obj.age)
            return 1;
        else
            return -1;
    }
}
