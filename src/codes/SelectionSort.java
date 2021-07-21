import java.util.Arrays;

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
 * 1) The subarray which is already sorted.
 * 2) Remaining subarray which is unsorted.
 * In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.
 * Following example explains the above steps:
 * arr[] = 64 25 12 22 11
 *
 * // Find the minimum element in arr[0...4]
 * // and place it at beginning
 * 11 25 12 22 64
 *
 * // Find the minimum element in arr[1...4]
 * // and place it at beginning of arr[1...4]
 * 11 12 25 22 64
 *
 * // Find the minimum element in arr[2...4]
 * // and place it at beginning of arr[2...4]
 * 11 12 22 25 64
 *
 * // Find the minimum element in arr[3...4]
 * // and place it at beginning of arr[3...4]
 * 11 12 22 25 64
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println(Arrays.toString(sort(arr)));
    }
    
    /**
     * Set the first element as minimum
     *
     */
    static int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted array
            int min_index  = i;
            for (int j = i + 1; j < n; j++) {
                System.out.print(j+" ");
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
