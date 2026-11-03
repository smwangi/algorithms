package strings;


import java.io.IOException;
import java.util.Scanner;
/**
 * AnagramDelete
 */
public class AnagramDelete {

    private static final Scanner scan = new Scanner(System.in);
    private static final int CHARS = 26;
    public static void main(String[] args) throws IOException {

        String a = scan.nextLine();
        String b = scan.nextLine();

        int res = makeAnagram(a,b);

        System.out.println("Number of chars to delete: "+String.valueOf(res));

        scan.close();
    }

    private static int makeAnagram(String a, String b){

        int[] arr = new int[CHARS];

        

        for(int i = 0; i<a.length();i++){
            arr[a.charAt(i)-'a']++;
            
        }

        
        for(int i = 0; i< b.length();i++){
            arr[b.charAt(i) -'a']--;
        }
        for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }

        for(int i = 0; i<arr.length;i++){
        }

        int ans = 0;
        for(int i=0;i<CHARS;i++){
            ans += Math.abs(arr[i]);
        }

        return ans;
    }
}