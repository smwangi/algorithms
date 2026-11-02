import java.util.Arrays;
import java.util.List;

public class OCP {
    public static void main(String[] args) {
        List<String> l = Arrays.asList("A","B","C","D");
        long count = l.stream().peek(System.out::println).count();
        System.out.println(count);
    }
}
