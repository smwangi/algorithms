import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Find if array has an element whose value is half of array sum
 *
 * Given a sorted array (with unique entries), we have to find whether there exist an element(say X)
 * which is exactly half the sum of all the elements of the array including X.
 *
 * Examples:
 *
 * Input : A = {1, 2, 3}
 * Output : YES
 * Sum of all the elements is 6 = 3*2;
 *
 * Input : A = {2, 4}
 * Output : NO
 * Sum of all the elements is 6, and 3 is not present in the array.
 *
 * 1. Calculate the sum of all the elements of the array.
 * 2. There can be two cases
 * ….a. Sum is Odd, implies we cannot find such X, since all entries are integer.
 * ….b. Sum is Even, if half the value of sum exist in array then answer is YES else NO.
 * 3. We can use Binary Search to find if sum/2 exist in array or not (Since it does not have duplicate entries)
 *
 * Below is the implementation of above approach:
 */
public class HalfArraySum {
    public static void main(String[] args) {
        int array[] = { 1, 2, 3 };
        int n = array.length;
        if (checkForElement(array, n))
            System.out.println( "Yes");
        else
            System.out.println( "No");
        
        if (checkForElement2(array, n))
            System.out.println( "Yes");
        else
            System.out.println( "No");
    }
    static boolean checkForElement(int[] arr, int n) {
        // Sum of all array elements
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        // If sum is odd
        if (sum % 2 > 0)
            return false;
        sum /= 2; // If sum is even
        // Do binary search for the required element
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == sum)
                return true;
            else if (arr[mid] > sum)
                end = mid + 1;
            else
                start = mid + 1;
        }
        return false;
    }
    /**
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     *
     * Another efficient solution that works for unsorted arrays also
     * The idea is to use hashing.
     */
    static boolean checkForElement2(int[] arr, int n) {
        // Sum of all array elements and sorting in a hash table
        Set<Integer> s = new LinkedHashSet<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            s.add(arr[i]);
        }
        // If sum/2 is present in hash table
        if (sum % 2 == 0 && s.contains(sum / 2) && (sum / 2) == s.stream().skip(s.size() - 1).findFirst().get()) {
            return true;
        } else {
            return false;
        }
    }
}
