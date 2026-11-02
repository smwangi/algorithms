import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Find `k` closest elements to a given value in an array
 * Given a sorted integer array, find the k closest elements to x in the array where k and x are given positive integers
 *
 * The integer may or may not be present in the input array. if x is less than or equal to the first element in the array,
 * return first k elements. Similarly, if x is more than or equal to the last element in the input array, return the last k elements.
 * The returned elements should be in the same order as present in the input array.
 *
 * For example:
 * Input:  [10, 12, 15, 17, 18, 20, 25], k = 4, x = 16
 *
 * Output: [12, 15, 17, 18]
 *
 * Input:  [2, 3, 4, 5, 6, 7], k = 3, x = 1
 *
 * Output: [2, 3, 4]
 *
 * Input:  [2, 3, 4, 5, 6, 7], k = 2, x = 8
 *
 * Output: [6, 7]
 *
 * The idea is to do a linear search to find the insertion point i. The insertion point is defined as the point at which
 * the key x would be inserted into the array, i.e, the index of the first element greater than the key, or the array's size if all
 * elements in the array are less than the specified key. Then compare the elements around the insertion point i to get
 * the first k closest elements. The time complexity of this solution is O(n), where n is the size of the input.
 */
public class KClosestElements {
    public static void main(String[] args) {
        int[] arr = {10, 12, 15, 17, 18, 20, 25};
        int x = 16, k = 4;
        System.out.println(findKClosestElements(arr, k, x));
    }
    static List<Integer> findKClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }
        return Arrays.stream(arr, left, right + 1).boxed().collect(Collectors.toList());
    }
}
