import java.util.Arrays;

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
 * from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
 * 1) The subarray which is already sorted.
 * 2) Remaining subarray which is unsorted.
 *
 * In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted
 * subarray is picked and moved to the sorted subarray.
 *
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
        //System.out.println(Arrays.toString(sort(arr)));
        System.out.println(Arrays.toString(selectionSort(arr)));
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
                // To sort the descending order, change > to < in this line.
                // Select the minimum element in each loop
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            // Put min at the correct position
            // Swap the found minimum element with the first element
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    
    static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return new int[] {};
        
        int N = array.length;
        for (int i = 0; i < N; i++) {
            int min_idx = i;
            for (int j = i + 1; j < N; j++) {
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
        return array;
    }
    static int[] selectionSort2(int[] array) {
        if (array.length == 0)
            return new int[] {};
        
        int startIdx = 0, N = array.length;
        while (startIdx < N - 1) {
            int smallestIdx = startIdx;
            for (int i = startIdx + 1; i < N; i++) {
                if (array[smallestIdx] > array[i])
                    smallestIdx = i;
            }
            swap(startIdx, smallestIdx, array);
            startIdx++;
        }
        return array;
    }
    
    static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
