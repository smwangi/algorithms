import java.util.Spliterator;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {

        treeSetExample();
    }

    static void treeSetExample(){
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("C");

        treeSet.add("C");
        treeSet.add("Geek");
        treeSet.add("For");
        treeSet.add("Geeks");

        System.out.println(treeSet);
        System.out.println(treeSet.contains("A"));
        System.out.println(treeSet.contains("D"));
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println(treeSet.floor("B"));
        System.out.println(treeSet.lower("B"));

        TreeSet<Employee> employeeTreeSet = new TreeSet<>();
        employeeTreeSet.add(new Employee("Sam",11,344.00));
        employeeTreeSet.add(new Employee("Wan",131,144.00));
        employeeTreeSet.add(new Employee("Mwaz",51,544.00));

        for (Employee s:employeeTreeSet){

        }
        Spliterator<Employee> spliterator = employeeTreeSet.spliterator();
        spliterator.forEachRemaining(x -> System.out.println(x.name));


    }
    static class Employee implements Comparable<Employee>{
        private String name;
        private int age;
        private double salary;

        Employee(String name, int age, double salary){
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public int compareTo(Employee o) {
            if(age == o.age)return 0;
            else if(age > o.age)return 1;
            else return -1;
        }
    }
}
