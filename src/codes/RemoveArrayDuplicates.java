import java.util.Arrays;

/**
 * Time Complexity: O(n)
 *
 * Space Complexity: O(n)
 */
public class RemoveArrayDuplicates {
    public static void main(String[] args) {
    
        int[] arr = {18, 18, 25, 25, 25, 28, 28, 29};
        System.out.println(removeDuplicatesUnSortedArr(arr));
    }
    
    // check if the ith element is not equal to
    // the (i+1)th element, then add that element
    // at the jth index in the same array
    // which indicates that te particular element
    // will only be added once in the array
    static int removeDuplicatesUnSortedArr(int[] arr) {
        int[] temp = new int[arr.length];
        int n = arr.length;
        if(n == 0 || n == 1) return n;
        int j = 0;
        for (int i = 0; i < n-1; i++) {
            if (arr[i] != arr[i+1]) {
                temp[j++] = arr[i];
            }
        }
    
        // Store the last element as whether
        // it is unique or repeated, it hasn't
        // stored previously
        temp[j++] = arr[n-1];
        System.out.println("J: "+j);
        for (int i = 0; i < j; i++) {
            arr[i] = temp[i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(temp));
        return j;
    }
}
