/**
 * Find the Rotation Count in Rotated Sorted array
 * Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise) k number of times.
 * Given such an array, find the value of k.
 *
 * Examples:
 *
 * Input : arr[] = {15, 18, 2, 3, 6, 12}
 * Output: 2
 * Explanation : Initial array must be {2, 3,
 * 6, 12, 15, 18}. We get the given array after
 * rotating the initial array twice.
 *
 * Input : arr[] = {7, 9, 11, 12, 5}
 * Output: 4
 *
 * Input: arr[] = {7, 9, 11, 12, 15};
 * Output: 0
 *
 * Method 1 (Using linear search)
 *
 * If we take closer look at examples, we can notice that the number of rotations is equal to index of minimum element.
 * A simple linear solution is to find minimum element and returns its index. Below is C++ implementation of the idea.
 */
public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
        int n = arr.length;
        System.out.println(countRotations(arr, n));
        System.out.println(countRotations(arr, 0, n - 1));
    }
    /**
     * Returns count of rotations for an array which is first sorted in
     * ascending order, then rotated
     */
    static int countRotations(int[] arr, int n) {
        // We basically find index of minimum element
        int min = arr[0], min_index = -1;
        for (int i = 0; i < n; i++) {
            if (min > arr[i]) {
                min = arr[i];
                min_index = i;
            }
        }
        return min_index;
    }
    /**
     * Time Complexity : O(n)
     * Auxiliary Space : O(1)
     *
     * Method 2 (Efficient Using Binary Search)
     * Here are also we find index of minimum element, but using Binary Search. The idea is based on below facts :
     *
     * The minimum element is the only element whose previous is greater than it. If there is no previous element,
     * then there is no rotation (first element is minimum). We check this condition for middle element by comparing it with
     * (mid-1)’th and (mid+1)’th elements.
     * If minimum element is not at middle (neither mid nor mid + 1), then minimum element lies in either left half or right half.
     * If middle element is smaller than last element, then the minimum element lies in left half
     * Else minimum element lies in right half.
     * Below is the implementation taken from here.
     */
    // Returns count of rotations for an array
    // which is first sorted in ascending order,
    // then rotated
    static int countRotations(int[] arr, int low, int high) {
        // This condition is needed to handle
        // the case when array is not rotated
        // at all
        if (high < low)
            return 0;
        // If there is only one element left
        if (high == low)
            return low;
        // Find mid
        // (low + high)/2
        int mid = low + (high - low)/2;
        // Check if element (mid+1) is minimum element. Consider the cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid+1] < arr[mid])
            return (mid + 1);
        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid-1])
            return mid;
        // Decide whether we need to go to the left half or right half
        if (arr[high] > arr[mid])
            return countRotations(arr, low, mid - 1);
        return countRotations(arr, mid + 1, high);
    }
}
