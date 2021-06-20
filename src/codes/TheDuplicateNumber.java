
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class TheDuplicateNumber {

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(duplicateNum(arr));
    }


    private static int duplicateNum(int[] arr){
        int dup = 0;
        Set<Integer> duplicateNum = new HashSet<>();

        for(int i = 0; i< arr.length;i++){


            if(!duplicateNum.contains(arr[i])){
                duplicateNum.add(arr[i]);
            }else{
                dup = arr[i];
                break;
            }
        }
        return dup;
    }
    /**
     * Complexity Analysis
     *
     * Time complexity : \mathcal{O}(n)O(n)
     *
     * Set in both Python and Java rely on underlying hash tables, so insertion and lookup have amortized constant time complexities.
     * The algorithm is therefore linear, as it consists of a for loop that performs constant work nn times.
     *
     * Space complexity : \mathcal{O}(n)O(n)
     *
     * In the worst case, the duplicate element appears twice, with one of its appearances at array index n-1n−1.
     * In this case, seen will contain n-1n−1 distinct values, and will therefore occupy \mathcal{O}(n)O(n) space.
     */
}
