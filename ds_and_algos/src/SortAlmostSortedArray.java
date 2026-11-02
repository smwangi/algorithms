import java.util.Arrays;

/**
 * Sort an almost sorted array where only two elements are swapped
 * Given an almost sorted array where only two elements are swapped, how to sort the array efficiently?
 * Examples :
 *
 * Input:  arr[] = {10, 20, 60, 40, 50, 30}
 * // 30 and 60 are swapped
 * Output: arr[] = {10, 20, 30, 40, 50, 60}
 *
 * Input:  arr[] = {10, 20, 40, 30, 50, 60}
 * // 30 and 40 are swapped
 * Output: arr[] = {10, 20, 30, 40, 50, 60}
 *
 * Input:   arr[] = {1, 5, 3}
 * // 3 and 5 are swapped
 * Output:  arr[] = {1, 3, 5}
 *
 * The idea is to traverse from rightmost side and find the first out of order element (element which is smaller than previous element).
 * Once first element is found, find the other our of order element by traversing the array toward left side
 */
public class SortAlmostSortedArray {
    public static void main(String[] args) {
        int arr[] = {10, 30, 20, 40, 50, 60, 70};
        int n = arr.length;
        sortByOneSwap(arr, n);
        System.out.println(Arrays.toString(arr));
    }
    static void sortByOneSwap(int[] arr, int n) {
        // Traverse the given array from right most side
        for (int i = n - 1; i >= 0; i--) {
            // Check if arr[i] is not in order
            if (arr[i] < arr[i - 1]) {
                // Find the other element to be swapped with arr[i]
                int j = i - 1;
                while (j >= 0 && arr[i] < arr[j]) {
                    j--;
                }
                // Swap the pair
                int temp = arr[i];
                arr[i] = arr[j + 1];
                arr[j + 1] = temp;
                break;
            }
        }
    }
}
