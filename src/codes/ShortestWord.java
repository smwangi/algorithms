package codes;

import java.util.Arrays;
import java.util.stream.Stream;

public class ShortestWord {

    public static void main(String[] args) {
        String s = "this is very different";
        System.out.println(shortestWord(s));
        System.out.println(findShort(s));
    }

    static int shortestWord(String s){
        return Stream.of(s.split(" "))
                .mapToInt(String::length)
                .min()
                .getAsInt();
    }

    static int findShort(String s){
        return Arrays.stream(s.split(" ")).mapToInt(String::length).min().getAsInt();
    }
}
