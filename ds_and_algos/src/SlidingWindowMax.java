import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Sliding Window Maximum (Maximum of all sub-arrays of size k)
 * <p>
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
 * Output: 3 3 4 5 5 5 6
 * Explanation:
 * Maximum of 1, 2, 3 is 3
 * Maximum of 2, 3, 1 is 3
 * Maximum of 3, 1, 4 is 4
 * Maximum of 1, 4, 5 is 5
 * Maximum of 4, 5, 2 is 5
 * Maximum of 5, 2, 3 is 5
 * Maximum of 2, 3, 6 is 6
 * <p>
 * Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
 * Output: 10 10 10 15 15 90 90
 * <p>
 * Explanation:
 * Maximum of first 4 elements is 10, similarly for next 4
 * elements (i.e. from index 1 to 4) is 10, So the sequence
 * generated is 10 10 10 15 15 90 90
 */
public class SlidingWindowMax {
    ArrayDeque<Integer> deq = new ArrayDeque<>();
    int[] A;
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 3;
        printKMax(arr, arr.length, k);
        System.out.println();
        int[] result = maxSlidingWindow(arr, k);
        Arrays.stream(result).forEach(x -> System.out.print(x + " "));
        System.out.println();
        int[] res = slidingWindowMax(arr, k);
        Arrays.stream(res).forEach(x -> System.out.print(x + " "));
        System.out.println();
        int[] resultDp = slidingWindowMaxDP(arr, k);
        Arrays.stream(resultDp).forEach(x -> System.out.print(x + " "));
    }

    /**
     * Method 1: This is a simple method to solve the above problem.
     * <p>
     *
     * Approach:
     * The idea is very basic run a nested loop, the outer loop which will mark the starting point of the sub-array of length k,
     * the inner loop will run from the starting index to index+k, k elements from starting index and print the maximum element
     * among these k elements.
     * <p>
     * Algorithm:
     * Create a nested loop, the outer loop from starting index to n – k th elements. The inner loop will run for k iterations.
     * Create a variable to store the maximum of k elements traversed by the inner loop.
     * Find the maximum of k elements traversed by the inner loop.
     * Print the maximum element in every iteration of outer loop
     *
     * @param k
     *
     * Complexity Analysis:
     * Time Complexity: O(N * K).
     * The outer loop runs n-k+1 times and the inner loop runs k times for every iteration of outer loop.
     * So time complexity is O((n-k+1)*k) which can also be written as O(N * K).
     * Space Complexity: O(1).
     * No extra space is required.
     */
    static void printKMax(int[] arr, int n, int k){
        int j,max;
        for(int i = 0; i <= n-k; i++){
            max = arr[i];
            for (j=1; j < k; j++){
                if(arr[i+j] > max)
                    max = arr[i+j];
            }
            System.out.print(max+" ");
        }
    }

    // This approach takes O(N * K) which would give a time limit for large values of K
    static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return new int[0];
        if (n * k == 0) return new int[0];
        int[] result = new int[n - k + 1];// 9 - 3 + 1 = 7
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < i + k; j++) {
                max = Math.max(max, arr[j]);
            }
            result[i] = max;
        }
        return result;
    }

    /**
     * Method 2: Using Deque
     * To reduce time complexity, we can use a max heap, since the maximum element is always present
     * at the top of the heap, but an insertion in a max heap of size K takes O(logK) time.
     * Algorithm:
     * Initialize the first k elements in deque
     * Iterate over the heap array and for each element:
     *  Consider only the indices of the elements in the current window
     *  Pop out all the elements that are smaller than the current element
     *  Push the current element into the deque
     *  Push the first element of the deque, deque[0] into the result array
     */
    static int[] slidingWindowMax(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k <= 0) {
            return new int[0];
        }
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k+1) {
                deque.pollFirst();
            }

            // Remove indices of elements smaller than the current element
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Store the maximum element for the current window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    /**
     * Method 3: Using Dynamic Programming
     * 1. First initialize arrays to store the maximum elements for each sub-array from left to right (maxLeft) and right to left (maxRight). We also initialize an
     * array `result` to store the maximum elements for each sliding window.
     * 2. Compute Maximum Elements: Iterate through the array and compute the maximum elements for each sub-array of size k from left to right and right to left. For
     * maxLeft, we start from the beginning of the array and update the maximum element for each sub-array of size k. For maxRight, we start from the end of the array
     * and update the maximum element for each sub-array of size k.
     * 3. Compute Sliding Window Maximum: Iterate through the array and compute the maximum element for each sliding window of size k. The maximum element for each sliding
     * 4. Return Result: Return the result array containing the maximum elements for each sliding window.
     * @param nums
     * @param k
     * @return
     */
    static int[] slidingWindowMaxDP(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <=0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = nums[0];
        maxRight[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            maxLeft[i] = (i % k == 0) ? nums[i] : Math.max(maxLeft[i - 1], nums[i]);
            int j = n - i - 1;
            maxRight[j] = (j % k == 0) ? nums[j] : Math.max(maxRight[j + 1], nums[j]);
        }

        for (int i = 0, j = 0; i + k <= n; i++) {
            result[j++] = Math.max(maxRight[i], maxLeft[i + k - 1]);
        }

        return result;
    }
}
