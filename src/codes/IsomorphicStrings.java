
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Two String are isomorphic if all occurences of each character in X can be replaced with another
 * character to get Y and vice-versa
 * Consider Strings "ACAB" and "XCXY". They are isomorphic as we can map 'A'->'X' 'B' -> 'Y' and 'C' -> 'C'
 * Mapping from a character to itself is allowed, but no two characters may be replaced by the same character.
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class IsomorphicStrings {
    public static void main(String[] args) {

        String str1 = "sam";
        String str2 = "wan";
       // System.out.println(ismorphic(str1,str2));
        //System.out.println(smallest(125));
        //System.out.println(smallestOneZeroMultiple(1));
        //System.out.println(Long.parseLong("111",2));
        //String str = "0101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101010101";
        //System.out.println(nonNegNumV(str));
        int[]arr = {3,5,6,3,3,5};
        System.out.println(equalIndices(arr));
    }

    static boolean ismorphic(String str1, String str2){

        if(str1.length() != str2.length())
            return false;

        Map<Character,Character> strMap = new HashMap<>();
        Set<Character> mappedChars = new HashSet<>();

        for(int i = 0; i < str1.length();i++){
            char x = str1.charAt(i);
            char y = str2.charAt(i);

            //check if x is seen before
            if(strMap.containsKey(x)){
                //return false if the first occurrence of x is mapped to different character
                if(strMap.get(x) != y)
                    return false;
            }else{//if x is seen for the first time (not mapped yet)
                //return false if y is already mapped to some other character in x
                if(mappedChars.contains(y))
                    return false;

                //map x to y and mark is as mapped
                strMap.put(x,y);
                mappedChars.add(y);
            }

        }
        mappedChars.stream().forEachOrdered(System.out::println);
        return true;
    }

    public static int findDivisibleNum(int k) {
        Set<Integer> numList = new ConcurrentSkipListSet<>();
        numList.add(0);
        numList.add(1);

        for(int i = 10; i < Integer.MAX_VALUE; i = i * 10) {
            HashSet<Integer> newList = new LinkedHashSet<>();
            for(Integer num : numList) {
                newList.add(num + i);
            }
            for(Integer num : newList) {
                if(num != 0 && num % k == 0) {
                    return num;
                }
            }
            numList.addAll(newList);
        }
        return -1;
    }
    static long smallestOneZeroMultiple(int A)
    {
        for (long result = 1; result < Long.MAX_VALUE; result++) {
            String binValue = Long.toBinaryString(result);
            long toDecimal = Long.parseLong(binValue);
            if ((toDecimal % A) == 0) {
                return toDecimal;
            }
        }

        return 0; // or other sentinal, or throw exception if you like.
    }

    static int  nonNegNumV(String s){
        if(s == null)
            return 0;

        System.out.println("STR LEN: "+s.length());
        double num = Double.longBitsToDouble(Double.doubleToLongBits(new BigInteger(s, 2).doubleValue()));;//new BigInteger(s,2).doubleValue();//Long.parseLong(s,2);
        int iterations = 0;
        while (num > 0){

            if(num % 2 == 0){
                num /=2;
            }else{
                num -=1;
            }
            iterations++;
        }
        return iterations;
    }

    public static int equalIndices(int[] A) {
        int ans = 0;

        // for each index i and j
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {

                // finding the index with same
                // value but different index.

                if (A[i] == A[j] && i < j) {
                    ans++;
                    System.out.println(i + "," + j);
                }
                System.out.println(i+","+j);
            }
        }
        return ans;
    }

    static int next_number(int num){

        int[] digits = new int[num];
        int x,y,i;
        for(i=0; i<10; i++)
            digits[i]=0;

        int divisor = 10;
        int multiplier = 1;
        /* While we have processed all digis of the number */
        while(num > 0){
            /* get the rightmost digit in the number */
            x = num %divisor;

            /* Store it for sorting and finding next higher number than pivot */
            digits[x]++;

            /* Get the left digit of rightmost digit i.e x */
            y = (num % (divisor *10))/divisor;

 /* If left digit is less than right one,
     this digit needs to be swapped */
            if(y !=0  && y<x){
                for(i=y; i<10; i++){
                    /* search for number which is least greater than y pivot */
                    if(digits[i] !=0){
                        digits[i]--;
                        digits[y]++;
                        break;
                    }
                }
                /* Swap that digit with pivot i.e y */
                num  =  num /100;
                num = num *100 + i*10 ;
                break;
            }
            else{
       /* If left digit is greater than right one,
          just remove the last digit and continue. */
                num = num/divisor;
                multiplier *= 10;
            }
        }
        /* If all the digits are in sorted order, there is no number possible */
        if(num == 0)
            return -1;

        /* Restore the number without digits  after pivot */
        num = num * multiplier;
        int temp = 0;
        /*Calculate the number with digits after pivot in non increasing order */
        for(i=0;i<10;){
            while(digits[i] != 0){
                temp = temp + (i) * multiplier;
                digits[i]--;
                multiplier/=10;
            }
            i++;
        }
        return num + temp;
    }

    static int smallest(int n){
        int smallestSum = Integer.MAX_VALUE;
        int p = 0;
        List<Integer> sm = new ArrayList<>();
        for(int i = 1000; i > 0; i--){
            int remainder = i/10;
            int lastNum = i%10;
            int s = lastNum + (remainder%10);
            System.out.println(i+" <> "+s);
            if(s  < smallestSum){
                smallestSum = s;
                p = i;
                sm.add(i);
                System.out.println(i+" : "+smallestSum);
            }

        }
        sm.forEach(System.out::println);
        System.out.println(p+" : "+smallestSum);
        return p;
    }
}
