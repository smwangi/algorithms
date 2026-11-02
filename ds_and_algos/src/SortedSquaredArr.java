import java.util.Arrays;

/**
 * Sorted Squared Array
 * Write a function that takes in a non-empty array of integers that are sorted in ascending order and return a new
 * array of the same length with the squares of the original integers also sorted in ascending order
 */
public class SortedSquaredArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 9};
        System.out.println(Arrays.toString(sortedSquaredArray(arr)));
        
        int arr2[] = { -6, -3, -1, 2, 4, 5 };
        int n = arr2.length;
    
        System.out.println("Before sort ");
        for(int i = 0; i < n - 1; i++) {
            System.out.print(arr2[i] + " ");
        }
        
    
        int[] res = sortedSquaredArray2(arr2);
        System.out.println("");
        System.out.println("After Sort ");
        for(int i = 0; i < n; i++)
            System.out.print(res[i] + " ");
    }
    public static int[] sortedSquaredArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i];
        }
        Arrays.sort(array);
        return array;
    }
    /**
     * Two pointer method.
     * Compare the first and last element to check which is bigger and proceed with the result
     * Algorithm:
     *  Initialize left = 0 and right = n - 1
     *  If abs(left) >= abs(right) then store square(arr[left]) at the end of result array and increment left pointer
     *  else store square(arr[right]) in the result array and decrement right pointer
     *  decrement index of result array
     */
    public static int[] sortedSquaredArray2(int[] array) {
        int n = array.length, left = 0, right = n - 1;
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(array[left]) > Math.abs(array[right])) {
                result[i] = array[left] * array[left];
                left++;
            } else {
                result[i] = array[right] * array[right];
                right--;
            }
        }
        return result;
    }
}
