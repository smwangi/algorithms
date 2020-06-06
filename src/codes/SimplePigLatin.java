package codes;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.Character.isAlphabetic;

public class SimplePigLatin {

    public static void main(String[] args) {
        String s = "Pig latin is cool !";
        System.out.println(pigIt(s));
        System.out.println(pigIt3(s));
    }

    static String pigIt(String s){
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < words.length; i++){
            char[] arr = words[i].toCharArray();
            swap(arr,arr.length-1);
            //System.out.println(String.valueOf(arr)+"ay");
            boolean isChar = String.valueOf(arr).matches("^[a-zA-Z]*$");
            //sb.append(String.valueOf(arr)+"ay").append(" ");
            sb.append(arr);
            if(isChar)
                sb.append("ay ");
        }
        return sb.toString();
    }

    private static void swap(char[] arr, int len){
        char c = arr[0];
        for(int i = 0; i < len;i++){
            arr[i] = arr[i+1];
        }
        arr[len] = c;
    }

    public static String pigIt1(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }

    public static String pigIt2(String str) {
        return Arrays.stream(str.trim().split(" "))
                .map(v -> v.matches("[a-zA-Z]+") ? v.substring(1).concat(v.substring(0, 1)).concat("ay") : v)
                .collect(Collectors.joining(" "));
    }

    public static String pigIt3(String str) {
        StringBuilder result = new StringBuilder();

        for (String s : str.split(" ")) {
            char firstLetter = s.charAt(0);

            result.append(s, 1, s.length())
                    .append(firstLetter)
                    .append(isAlphabetic(firstLetter) ? "ay" : "")
                    .append(" ");
        }

        return result.substring(0, result.length()-1);
    }
}
