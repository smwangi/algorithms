import java.util.function.*;
/**
 * ConsumerTest
 */
public class ConsumerTest {

    public static void main(String[] args) {
        
        Consumer<String> cs1 = (arg)->{
            System.out.println(arg+" OK!");
        };
        cs1.accept("Man");
    }
}