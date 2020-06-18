package codes;

import java.util.HashMap;
import java.util.HashSet;

public class Toptal {

    public static void main(String[] args) {

        String s  = "babaa";
       // solution(s);
        solution2("ABBBCCDDCCC", 3);
    }

    public static int solution(String S) {
        // write your code in Java SE 8
        int n = S.length();
        if(n < 1 || n > 40000)
            return 0;

        if(((S == null) && (S.equals("")) && !(S.matches("^[a-b]*$"))))
            return 0;
        int count = 0;

        for(int i = 1; i < n; i++){

            for(int j = i+1;j<n;j++){
                //if(S.charAt(i) == 'a' && S.charAt(j))
                for(int k = j+1;k < n;k++){
                    String s1 = "", s2 = "", s3 = "";
                    try
                    {
                        s1 = S.substring(0, i);
                        s2 = S.substring(i, j - i);
                        s3 = S.substring(j, k - j);
                    }
                    catch (StringIndexOutOfBoundsException e) {
                    }
                    if(s1.indexOf('a') != -1 | s2.indexOf('a') != -1 | s3.indexOf('a') != 1)
                        count++;
                    //System.out.println(s1+" "+s2+" "+s3);
                }
            }
        }
       // System.out.println(count);
        return count;
    }

    public static int solution2(String S, int K) {
        // write your code in Java SE 8
        int n = S.length();
        int len = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        HashSet<Character>seen = new HashSet<>();
        HashMap<Character,Integer> cnt = new HashMap<>();
        for(int i = 0; i < n;i++){

            char c = S.charAt(i);
            int count = 1;
            for(int j = i+K;j<n;j++){
                //System.out.print(S.charAt(j)+" ");
                if(S.charAt(i) ==  S.charAt(j)){
                    count++;

                }

            }

            if(count > 1){
                //i+=count;
                sb.append(count).append(c);
            }else{
                sb.append(c);
                //i++;
            }
            if(sb.length() < len)
                len = sb.length();

            System.out.print(c+""+count);
        }
        //System.out.println(sb.toString());
        return len;
    }
}
