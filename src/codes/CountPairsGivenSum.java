import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, and a number ‘sum’, find the number of pairs of integers in the array whose sum is equal to ‘sum’.
 *
 * Examples:
 *
 * Input  :  arr[] = {1, 5, 7, -1},
 *           sum = 6
 * Output :  2
 * Pairs with sum 6 are (1, 5) and (7, -1)
 *
 * Input  :  arr[] = {1, 5, 7, -1, 5},
 *           sum = 6
 * Output :  3
 * Pairs with sum 6 are (1, 5), (7, -1) &
 *                      (1, 5)
 *
 * Input  :  arr[] = {1, 1, 1, 1},
 *           sum = 2
 * Output :  6
 * There are 3! pairs with sum 2.
 *
 * Input  :  arr[] = {10, 12, 10, 15, -1, 7, 6,
 *                    5, 4, 2, 1, 1, 1},
 *           sum = 11
 * Output :  9
 * Expected time complexity O(n)
 *
 * Naive Solution – A simple solution is to traverse each element and check if there’s another number in the array which can be added to it to give sum.
 */
public class CountPairsGivenSum {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 7, -1, 5 };
        int sum = 6;
        getPairsCount(arr, sum);
    }
    static void getPairsCount(int[] arr, int sum) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum)
                    count++;
            }
        }
        System.out.printf("Count of pairs is %d ", count);
    }
    /**
     * Efficient solution –
     * A better solution is possible in O(n) time. Below is the Algorithm –
     *
     * Create a map to store frequency of each number in the array. (Single traversal is required)
     * In the next traversal, for every element check if it can be combined with any other element (other than itself!) to give the desired sum. Increment the counter accordingly.
     * After completion of second traversal, we’d have twice the required value stored in counter because every pair is counted two times. Hence divide count by 2 and return.
     */
    static int getPairsCount2(int[]arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        //Store counts of all elements in the map
        for (int i = 0; i < n; i++) {
            // initializing value to 0, if key not found
            if (map.containsKey(arr[i]))
                map.put(arr[i], 0);
            map.put(arr[i], map.get(arr[i]) + 1);
        }
        int twice_count = 0;
        // iterate through each element and increment the count, notice that every pair is counted twice
        for (int i = 0; i < n; i++) {
            if (map.get(sum - arr[i]) != null)
                twice_count += map.get(sum - arr[i]);
            // if (arr[i], arr[i]) pair satisfies the
            // condition, then we need to ensure that the
            // count is decreased by one such that the
            // (arr[i], arr[i]) pair is not considered
            if (sum - arr[i] == arr[i])
                twice_count--;
        }
        // return the half of twice_count
        return twice_count / 2;
    }
}
