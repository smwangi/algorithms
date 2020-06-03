package codes;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem:
 *
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 *
 *     The length of num is less than 10002 and will be ≥ k.
 *     The given num does not contain any leading zero. Example 1:
 *
 *     Input: num = "1432219", k = 3
 *     Output: "1219"
 *     Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *
 *     Example 2:
 *
 *     Input: num = "10200", k = 1
 *     Output: "200"
 *     Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 *
 *     Example 3:
 *
 *     Input: num = "10", k = 2
 *     Output: "0"
 *     Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class RemoveKDigits {

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKDigits(num,k));
    }

    static String removeKDigits(String num, int k){
        if(num.length() == k)
            return "0";

        StringBuilder sb = new StringBuilder(num);
    //System.out.println(sb.length());
        for(int j = 0; j < k; j++){
            int i = 0;

            while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i+1) ){
               // System.out.println(i);
                i++;
            }
           // System.out.print(" i "+i);
            sb.delete(i,i+1);
        }
        int i = 0;

        //Removes leading zeros
        while (i < sb.length() - 1 && sb.charAt(i) == '0'){
            i++;
        }

        return sb.substring(i);
    }

    static String removeKDigitsDeque(String num, int k){

        String newNum = "";
        int strLen = num.length();
        Deque<Character> characters = new ArrayDeque<>();

        int i = 0;
        for(int j = 0; j < k; j++){
            if(i > strLen || !characters.isEmpty() && characters.peek() > num.charAt(i)){
                characters.pop();
            }
            while (i < strLen -1 && num.charAt(i) <= num.charAt(i+1)){
                characters.push(num.charAt(i));
                i++;
            }
            i++;
        }
        while (i < num.length()){
            characters.push(num.charAt(i));
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (!characters.isEmpty()){
            sb.append(characters.pop());
        }
        i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0'){
            i++;
        }

        return sb.substring(i);

    }


}
