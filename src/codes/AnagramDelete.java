
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 * AnagramDelete
 */
public class AnagramDelete {

    private static final Scanner scan = new Scanner(System.in);
    private static final int CHARS = 26;
    public static void main(String[] args) throws IOException {

        //BufferedWriter writer = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scan.nextLine();
        String b = scan.nextLine();

        int res = makeAnagram(a,b);

        System.out.println("Number of chars to delete: "+String.valueOf(res));

        // writer.write(String.valueOf(res));
        // writer.newLine();

        // writer.close();
        scan.close();
    }

    private static int makeAnagram(String a, String b){

        int[] arr = new int[CHARS];

        

        for(int i = 0; i<a.length();i++){
            arr[a.charAt(i)-'a']++;
            //System.out.println(a.charAt(i));
            
        }

        
        for(int i = 0; i< b.length();i++){
            arr[b.charAt(i) -'a']--;
        }
        for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
        // System.out.println(arr['b'-'a']++);
        // System.out.println(arr['c'-'a']++);
        // System.out.println(arr['a'-'a']++);
        // System.out.println(arr['d'-'a']++);
        // System.out.println(arr['e'-'a']++);
        // System.out.println(arr['h'-'a']++);

        for(int i = 0; i<arr.length;i++){
            //System.out.print(arr[i]+" ");
        }

        int ans = 0;
        for(int i=0;i<CHARS;i++){
            ans += Math.abs(arr[i]);
        }

        return ans;
    }
}