import java.util.HashMap;
import java.util.Map;

/**
 * Find the count of distinct elements in every subarray of size `k`
 *
 * Input:
 *
 * arr[] = { 2, 1, 2, 3, 2, 1, 4, 5 };
 * k = 5;
 *
 * Output:
 *
 * The count of distinct elements in subarray { 2, 1, 2, 3, 2 } is 3
 * The count of distinct elements in subarray { 1, 2, 3, 2, 1 } is 3
 * The count of distinct elements in subarray { 2, 3, 2, 1, 4 } is 4
 * The count of distinct elements in subarray { 3, 2, 1, 4, 5 } is 5
 */
public class FindDistinctCount {
    
    public static void main(String[] args) {
        int[] arr = { 2, 1, 2, 3, 2, 1, 4, 5 };
        int k = 5;
    
        findDistinctCount(arr, k);
        System.out.println("XXXX");
        findDistinctCount2(arr, k);
    }
    static void findDistinctCount(int[] arr, int k) {
        // Consider every subarray of size `k`
        for (int x = 0; x <= arr.length - k; x++) {
            // maintains a counter for distinct elements in the current subarray
            int distinct = 0;
            //current subarray is formed by subarray `arr[x, x+k]`
            for (int i = x; i < x + k; i++) {
                distinct++;
                // check if `arr[i]` is present in subarray `arr[x, i-1]` or not
                for (int j = x; j < i; j++) {
                    // if duplicate element found in the current subarray
                    if (arr[i] == arr[j]) {
                        // unmark element `arr[i]` as distinct  -  decrease count
                        distinct--;
                        break;
                    }
                }
            }
            System.out.printf("The count of distinct elements in subarray [%d, %d]"
                    + " is %d\n", x, x + k - 1, distinct);
        }
    }
    /**
     * Sliding window O(n)
     * Store the frequency of elements in the current window in a map and keep tracj of the distinct elements count in the current
     * window (of size k)
     */
    static void findDistinctCount2(int[] A, int k) {
        // map to store frequency of elements in the current window of size `k`
        Map<Integer, Integer> freq = new HashMap<>();
        // maintains the count of distinct elements in every subarray of size `k`
        int distinct = 0;
        // loop through the array
        for (int i = 0; i < A.length; i++) {
            // ignore the first `k` elements
            if (i >= k){
                // remove the first element from the subarray by reducing its frequency in the map
                freq.put(A[i - k], freq.getOrDefault(A[i - k], 0) - 1);
                // reduce the distinct count if we are left with 0
                if (freq.get(A[i - k]) == 0) {
                    distinct--;
                }
            }
            // add the current element to the subarray by incrementing its count in the map
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);
            // increment distinct count by 1 if the element occurs for the first time in the current window
            if (freq.get(A[i]) == 1) {
                distinct++;
            }
            // print count of distinct elements in the current subarray
            if (i >= k - 1) {
                System.out.println("The count of distinct elements in subarray [" +
                        (i - k + 1) + ", " + i + "]" + " is " + distinct);
            }
        }
    }
}
