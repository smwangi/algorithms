import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an integer array, find the length of the longest subsequence formed by the consecutive integers. The
 * subsequence should contain all distinct values, and the character set should be consecutive, irrespective of its order.
 *
 * For example:
 * Consider array {2, 0, 6, 1, 5, 3, 7}
 * The largest subsequence formed by consecutive integers is {2, 0, 1, 3}
 * Note that the problem differs from finding the largest subarray formed by the consecutive integers. Unlike subarrays, subsequences
 * are not required to occupy consecutive positions within the original array.
 *
 * A naive solution would be to sort the array in ascending order and compare the consecutive elements to find the maximum length subarray
 * with consecutive integers. The time complexity of this solution would be O(n.log(n)), where n is the size of the given sequence.
 *
 * We can do better using hashing. The idea is to consider each input sequence element and find the maximum length of a consecutive
 * subsequence starting with i. i.e for every element e, check for the presence of element e+1, e+2, e+3,.... in the input. We can optimize
 * the code by using a set for constant-time look-ups to determine if the element present in the input sequence or not. The algorithm
 * can be implemented as below
 */
public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = { 2, 0, 6, 1, 5, 3, 7 };
    
        System.out.println("The length of the maximum consecutive subsequence is " +
                findMaxLenSubseq(arr));
    }
    
    static int findMaxLenSubseq(int[] arr) {
        //Set for input elements
        Set<Integer> set = IntStream.of(arr).boxed().collect(Collectors.toSet());
        int maxLen = 1;//initialize result to 1
        //do for each element of the input sequence
        for (int e: arr) {
            //check if the current element `e` is a candidate for starting a sequence
            // i.e., the previous element `e-1` doesn't exist in the set
            if (!set.contains(e - 1)) {
                //`len` stores the length of subsequence, starting with the current element.
                int len = 1;
                //check for present of elements `e+1`, `e+2`, `e+3`,.....,`e+len` in the set
                while (set.contains(e + len)) {
                    len++;
                }
                //update result with the length of current consecutive subsequence
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
