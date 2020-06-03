package codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrPermutation {

    public static void main(String[] args) {
        String s = "ABC";
       // iterative(s);
        recursive(s.toCharArray(),0);
    }

    //Recursive
    public static void recursive(char[] ch,int currentIndex){

        if(currentIndex == ch.length - 1){
            System.out.println(String.valueOf(ch));
        }
        for (int i = currentIndex; i < ch.length; i++ ){
            //System.out.println("Cur Index: "+currentIndex+" i "+i);
            //System.out.println(Arrays.toString(ch));
            swap(ch,currentIndex,i);
            recursive(ch,currentIndex+1);
            //System.out.println(Arrays.toString(ch));
            swap(ch,currentIndex,i);
            //System.out.println(Arrays.toString(ch));
        }
    }
    private static void swap(char[] cArr, int i, int j){
        char temp = cArr[i];
        cArr[i] = cArr[j];
        cArr[j] = temp;
    }

    //Iterative: Using Collection
    public static void iterative(String s){
        //Create a list to store partial permutations
        List<String>partial = new ArrayList<>();
        //Initalize the String with the first character of the String
        partial.add(String.valueOf(s.charAt(0)));

        //Do for every charater of the specified String
        for(int i = 1; i < s.length(); i++){
            //consider previously constructed partial permutation one by one
            //Iterate backwards to avoid concurrent modification exception
            for(int j = partial.size() - 1; j >= 0; j--){
                //remove the current partial permutation from the ArrayList
                String str  = partial.remove(j);
                //Insert next character of the specified string in all possible positions of the
                //current partial permutation. Then insert each of the newly constructed string in the list
                for(int k = 0; k  < str.length(); k++){
                    //Advice: use stringbuilder for concatenation
                    partial.add(str.substring(0,k) + s.charAt(i) + str.substring(k));
                }
            }
        }
        System.out.println(partial);
    }
}
