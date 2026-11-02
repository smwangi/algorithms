import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionLearn {
    BiFunction<String, String, String> concat = (s1, s2) -> s1.concat(s2);

    String concatStr(String s1, String s2) {
        return concat.apply(s1, s2);
    }

    public static void main(String[] args) {
        BiFunction<String, String, String> concat = (s1, s2) -> s1.concat(s2);
        Function<String, String> concatConstants = (s1) -> s1.concat("/edpresso");
        Function<String, String> convertToUpperCase = String::toUpperCase;
        String s1 = "Hello", s2 = " - Educative";
        BiFunction<String, String, String> stage1 = concat.andThen(concatConstants);
        BiFunction<String, String, String> stage2 = stage1.andThen(convertToUpperCase);
        System.out.println(stage2.apply(s1, s2));
    }
}
