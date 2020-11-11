
import java.util.*;

public class StrPermutation {

    public static void main(String[] args) {
        String s = "ABC";
       // iterative(s);
        recursive(s.toCharArray(),0);
        System.out.println("<> <> <> ");
        lsPermute(s).forEach(System.out::println);
        System.out.println("<> <> <> ");
        printPermtn(s,"");
        System.out.println("<> <> <> ");
        permute(s,0,s.length()-1);
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

    static void permute(String s){
        char[]chars = s.toCharArray();
        for (int i = 0;i<chars.length;i++){
            if(i%2 == 0){
                swap(chars,0,chars.length-1);
            }else {
                swap(chars,i,i+1);
            }
            System.out.println(chars.toString());
        }
    }

    private static List<String> lsPermute(String s){
        if(s == null)return null;
        List<String> result = new ArrayList<>();

        if(s.length()<2){
            result.add(s);
            return result;
        }

        List<String> permutations = lsPermute(s.substring(1));
//System.out.println(" 0 "+s.charAt(0)+" 1 "+s.charAt(1)+" size ");
        //permutations.forEach(System.out::println);
        for (String permutation: permutations){
            System.out.println("PE "+permutation+" "+permutation.length());
            for (int i = 0;i<=permutation.length();i++){
                System.out.println(i+" - "+permutation.substring(0,i)+" - "+s.charAt(0)+" - "+permutation.substring(i));
                String newPermutation = permutation.substring(0, i) + s.charAt(0)+ permutation.substring(i);
                result.add(newPermutation);
            }
        }
        return result;
    }

    static void printPermtn(String s,String ans){
        //If string is empty
        if(s.length() == 0){
            System.out.println(ans);
            return;
        }
        for (int i= 0; i < s.length(); i++){
            //ith character of s
            char ch = s.charAt(i);

            //Rest of the string after excluding the ith character
            String ros = s.substring(0,i) +
                    s.substring(i+1);

            printPermtn(ros,ans+ch);
        }
    }
    static void permute(String str,int l, int r){

        Set<Character>se = new HashSet<>(Arrays.asList('a','e'));
        if(l==r) System.out.println(str);
        else {
            for (int i = 1; i<=r;i++){
                str = swapStr(str,l,i);
                permute(str,l+1,r);
                str = swapStr(str,l,i);

            }
        }
    }

    static String swapStr(String str, int l,int r){
        char[] chars = str.toCharArray();
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;

        return String.valueOf(chars);
    }
}
