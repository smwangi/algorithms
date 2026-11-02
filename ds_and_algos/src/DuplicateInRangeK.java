import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array and a positive k, check whether the array contains any duplicate elements
 * within the range k. If k is more than the array's size, the solution should check for duplicates in the complete array.
 *
 * Input:
 *
 * A[] = { 5, 6, 8, 2, 4, 6, 9 }
 * k = 4
 *
 * Output: Duplicates found
 *
 * (element 6 repeats at distance 4 which is <= k)
 *
 *
 * Input:
 *
 * A[] = { 5, 6, 8, 2, 4, 6, 9 }
 * k = 2
 *
 * Output: No duplicates were found
 *
 * (element 6 repeats at distance 4 which is > k)
 *
 *
 * Input:
 *
 * A[] = { 1, 2, 3, 2, 1 }
 * k = 7
 *
 * Output: Duplicates found
 *
 * (element 1 and 2 repeats at distance 4 and 2, respectively which are both <= k)
 *
 * The problem can be efficiently solved using hashing O(n) time  and O(n) extra space. The idea is to traverse
 * the array and store each element and its index in a map, i.e (element, index) as (key, value) pairs in a map.
 * If any element is already found present in the map, check if that element repeats within the range of k using
 * its previous occurrence information from the map.
 */
public class DuplicateInRangeK {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 8, 2, 4, 6, 9 };
        int k = 4;
    
        if (hasDuplicate(arr, k)) {
            System.out.println("Duplicates found");
        }
        else {
            System.out.println("No duplicates were found");
        }
    }
    static boolean hasDuplicate(int[] arr, int k) {
        //Store the (element, index) pairs as (key, value) pairs
        //traverse the array
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            //if current element exists in the map
            if (map.containsKey(arr[i])) {
                //return true if the current element repeats within the range  of `k`
                if (i - map.get(arr[i]) <= k) {
                    return true;
                }
            }
            map.put(arr[i], i);
        }
        // we reach here when no element repeats within range k
        return false;
    }
    /**
     * Sliding window
     * The idea is to process every window of size k and store its elements in a set. If any element repeats in the window, we can say that
     * it repeats within the range of k.
     *
     * Initially, our window will contain the first k elements of the input. Then for each item of the remaining input, add it to the current window.
     * While adding i'th item of the input to the current window, remove the (i-k)'th element from it. This ensures the efficiency of the solution
     * and keeps the window balance at any point.
     */
    static boolean hasDuplicate2(int[] arr, int k) {
        //create an empty set to store elements within range k
        Set<Integer> window = new HashSet<>();
        //traverse the array
        for (int i = 0; i < arr.length; i++) {
            // if the current element already exists in the window, then it repeats within the range k
            if (window.contains(arr[i])) {
                return true;
            }
            // add the current element to the window
            window.add(arr[i]);
            //remove the element ar k`th range from the current element
            if (i >= k) {
                window.remove(arr[i - k]);
            }
        }
        // we reach here no element repeats within range k
        return false;
    }
}
