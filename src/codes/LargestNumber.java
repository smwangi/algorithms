import java.util.*;

/**
 * Find the largest number possible from a given set of numbers
 *
 * The idea is to write a custom comparator function for the sorting routing. For two numbers, X and Y, the custom comparator
 * function will compare X and Y with each other, but it compares XY with YX, and the greater number will come first in sorted order.
 * Here, XY denotes a number formed by appending Y to X and YX denotes a number formed by appending X to Y. For example, X = 15 and Y = 4,
 * XY = 154 and YX = 415
 *
 * As evident from the above example, X > Y but XY < YX, so the comparator function will consider Y > X
 */
public class LargestNumber {
    public static void main(String[] args) {
    
        LargestNumber largestNumber = new LargestNumber();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
        System.out.println(largestNumber.largestNumber2(nums));
    }
    
    static String largestNumber(int[] nums) {
        List<String> numbers = new ArrayList<>();
        for (int num : nums) numbers.add(num+"");
    
        Collections.sort(numbers, (a, b) -> (b + a).compareTo(a + b));
        
        numbers.stream().forEach(System.out::print);
        System.out.println();
        return numbers.toString();
    }
    
     String largestNumber2(int[] nums) {
        String[] strNums = new String[nums.length];
        String largest = "";
        
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strNums, new NumComparator());
        for (String s : strNums)
            largest +=s;
        
        return largest;
    }
    
    class NumComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String x = a + b;
            String y = b + a;
            return y.compareTo(x);
        }
    }
}
