/**
 * Maximum element in a sorted and rotated array
 *
 * Given a sorted array arr[] of distinct elements which is rotated at some unknown point, the task is to find the maximum element in it.
 * Examples:
 *
 *
 * Input: arr[] = {3, 4, 5, 1, 2}
 * Output: 5
 * Input: arr[] = {1, 2, 3}
 * Output: 3
 *
 * Approach: A simple solution is to traverse the complete array and find maximum. This solution requires O(n) time.
 * We can do it in O(Logn) using Binary Search. If we take a closer look at above examples, we can easily figure out the following pattern:
 *
 *
 * The maximum element is the only element whose next is smaller than it.
 * If there is no next smaller element, then there is no rotation (last element is the maximum).
 * We check this condition for middle element by comparing it with elements at mid – 1 and mid + 1.
 * If maximum element is not at middle (neither mid nor mid + 1), then maximum element lies in either left half or right half.
 * If middle element is greater than the last element, then the maximum element lies in the left half.
 * Else maximum element lies in the right half.
 */
public class MaxElemRotatedArr {
    public static void main(String[] args) {
        int arr[] = { 5, 6, 1, 2, 3, 4 };
        int n = arr.length;
        System.out.println(findMax(arr, 0, n - 1));
    }
    static int findMax(int[] arr, int low, int high) {
        // When array is not rotated at all
        if (high < low) {
            return arr[0];
        }
        // If there is only one element left
        if (high == low)
            return arr[low];
        
        int mid = low + (high - low) / 2;
        // Check if mid itself is maximum element
        if (mid < high && arr[mid + 1] < arr[mid])
            return arr[mid];
        // Decide whether we need to go to the left half or the right half
        if (arr[low] > arr[mid])
            return findMax(arr, low, mid - 1);
        else
            return findMax(arr, mid + 1, high);
    }
}
