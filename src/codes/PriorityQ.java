import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class PriorityQ {

    public static void main(String[] args) {
        //Create Priority Queue
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.add(750);
        numbers.add(500);
        numbers.add(900);
        numbers.add(100);

        while (!numbers.isEmpty())
            System.out.println(numbers.poll());

        //Creating a Priority Queue with a custom Comparator
        //A custom Comparator that compares two Strings by their length.
        Comparator<String> strLenComparator = Comparator.comparingInt(String::length);

        PriorityQueue<String> namePriorityQueue = new PriorityQueue<>(strLenComparator);
        namePriorityQueue.add("Lisa");
        namePriorityQueue.add("Robert");
        namePriorityQueue.add("John");
        namePriorityQueue.add("Chris");
        namePriorityQueue.add("Angelina");
        namePriorityQueue.add("Joe");

        while (!namePriorityQueue.isEmpty())
            System.out.println(namePriorityQueue.poll());

        testEmployee();

    }

    /**
     * Since a priority queue needs to compare its elements and order them accordingly, the user defined class must implement the Comparable interface,
     * or you must provide a Comparator while creating the priority queue. Otherwise, the priority queue will throw a ClassCastException when you add new objects to it.
     */
    static class Employee implements Comparable<Employee> {

        private String name;
        private double salary;

        public Employee(String name, double salary){
            this.name = name;
            this.salary = salary;
        }

        @Override
        public int compareTo(Employee employee) {

           if(this.getSalary() > employee.getSalary()){
               return 1;
           }else if(this.getSalary() < employee.getSalary()){
               return -1;
           }else {
               return 0;
           }
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj)return true;
            if(obj == null || getClass() != obj.getClass()) return false;

            Employee employee = (Employee)obj;

            return Double.compare(employee.salary,salary) == 0 && Objects.equals(name,employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, salary);
        }

        @Override
        public String toString() {
            return "Employee{"+
                    "name='"+name+'\''+
                    ", salary="+salary+
                    '}';
        }
    }

        /*
          The requirement for a PriorityQueue of user defined objects is that

          1. Either the class should implement the Comparable interface and provide
             the implementation for the compareTo() function.
          2. Or you should provide a custom Comparator while creating the PriorityQueue.
       */
    static void testEmployee(){
        PriorityQueue<Employee> employeePriorityQueue = new PriorityQueue<>();
        // Add items to the Priority Queue
        employeePriorityQueue.add(new Employee("Rajeev", 100000.00));
        employeePriorityQueue.add(new Employee("Chris", 145000.00));
        employeePriorityQueue.add(new Employee("Andrea", 115000.00));
        employeePriorityQueue.add(new Employee("Jack", 167000.00));

        /*
            The compareTo() method implemented in the Employee class is used to determine
            in what order the objects should be dequeued.
        */
        while (!employeePriorityQueue.isEmpty()) {
            System.out.println(employeePriorityQueue.remove());
        }
    }
}
