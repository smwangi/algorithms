import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers (both odd and even),
 * the task is to arrange them in such a way that odd and even values come in alternate fashion in non-decreasing order(ascending) respectively.
 *
 *
 * If the smallest value is Even then we have to print Even-Odd pattern.
 * If the smallest value is Odd then we have to print Odd-Even pattern.
 * Note: No. of odd elements must be equal to No. of even elements in the input array.
 * Examples:
 *
 *
 * Input: arr[] = {1, 3, 2, 5, 4, 7, 10}
 * Output: 1, 2, 3, 4, 5, 10, 7
 * Smallest value is 1(Odd) so output will be Odd-Even pattern.
 * Input: arr[] = {9, 8, 13, 2, 19, 14}
 * Output: 2, 9, 8, 13, 14, 19
 * Smallest value is 2(Even) so output will be Even-Odd pattern.
 */
public class OddEven {
    public static void main(String[] args) {
    
        int arr[] = { 9, 8, 13, 2, 19, 14 };
        int n = arr.length ;
    
        alternateRearrange(arr, n);
    }
    
    /**
     * Sort the given array.
     * Insert Even values in List-1 and Odd values in List-2.
     * Now if the smallest value is even, then insert an even value from list 1 and odd value from list 2 to original array and so on.
     * But if the smallest value is odd, then insert an odd value from list 2 and even value from list 1 to original array and so on.
     */
    static void alternateRearrange(int[] arr, int n) {
        Arrays.sort(arr);
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0)
                l1.add(arr[i]);
            else
                l2.add(arr[i]);
        }
        int index = 0, i = 0, j = 0;
        boolean flag = false;
        // set flag to true if first element is even
        if (arr[0] % 2 == 0)
            flag = true;
        // Start rearranging array
        while (index < n) {
            // if first element is even
            if (flag == true) {
                arr[index] = l1.get(i);
                i += 1;
                index += 1;
                flag = !flag;
            } else {
                // First element is Odd
                arr[index] = l2.get(j);
                j += 1;
                index += 1;
                flag = !flag;
            }
        }
        //Print the rearranged array
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+" ");
    }
}
