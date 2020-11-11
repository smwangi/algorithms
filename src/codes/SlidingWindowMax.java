/**
 * Sliding Window Maximum (Maximum of all sub-arrays of size k)
 *
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
 *
 * Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
 * Output: 10 10 10 15 15 90 90
 *
 * Explanation:
 * Maximum of first 4 elements is 10, similarly for next 4
 * elements (i.e from index 1 to 4) is 10, So the sequence
 * generated is 10 10 10 15 15 90 90
 */
public class SlidingWindowMax {
    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 3;
        printKMax(arr, arr.length, k);
    }

    /**
     * Method 1: This is a simple method to solve the above problem.
     *
     *
     * Approach:
     * The idea is very basic run a nested loop, the outer loop which will mark the starting point of the subarray of length k,
     * the inner loop will run from the starting index to index+k, k elements from starting index and print the maximum element
     * among these k elements.
     *
     * Algorithm:
     * Create a nested loop, the outer loop from starting index to n – k th elements. The inner loop will run for k iterations.
     * Create a variable to store the maximum of k elements traversed by the inner loop.
     * Find the maximum of k elements traversed by the inner loop.
     * Print the maximum element in every iteration of outer loop
     *
     * @param arr
     * @param n
     * @param k
     *
     * Complexity Analysis:
     * Time Complexity: O(N * K).
     * The outer loop runs n-k+1 times and the inner loop runs k times for every iteration of outer loop.
     * So time complexity is O((n-k+1)*k) which can also be written as O(N * K).
     * Space Complexity: O(1).
     * No extra space is required.
     */
    static void printKMax(int arr[],int n, int k){
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
}
