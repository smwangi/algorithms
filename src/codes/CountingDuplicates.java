package codes;

import java.util.*;

public class CountingDuplicates {
    public static void main(String[] args) {

        String text = "reallyLongStringContainingDuplicatesReturnsThree";
        System.out.println(countingDuplicates(text));
    }

    static int countingDuplicates(String text){
        int duplicates = 0;
        Set<Character> dupChar = new HashSet<>();
        List<Character> arr = Arrays.asList(text.toLowerCase().chars()
            .mapToObj(ch -> (char)ch).toArray(Character[]::new));

        for (char c : text.toCharArray()){
            if(Collections.frequency(arr,c) > 1){
                if(!dupChar.contains(c)){
                    dupChar.add(c);
                }
            }
        }
        dupChar.stream().forEach(System.out::println);
        return dupChar.size();
    }
}
