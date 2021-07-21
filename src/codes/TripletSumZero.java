import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Find all triplets with zero sum
 * Input : arr[] = {0, -1, 2, -3, 1}
 * Output : (0 -1 1), (2 -3 1)
 *
 * Explanation : The triplets with zero sum are
 * 0 + -1 + 1 = 0 and 2 + -3 + 1 = 0
 *
 * Input : arr[] = {1, -2, 1, 0, 5}
 * Output : 1 -2  1
 * Explanation : The triplets with zero sum is
 * 1 + -2 + 1 = 0
 *
 */
public class TripletSumZero {
    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        findTriplets(arr);
        findTriplets2(arr);
        findTriplets3(arr);
    }
    /**
     * Brute force
     * Takes O(n^3)
     * Approach: The naive approach runs three loops and check one by one that sum of three elements is zero or not.
     * If the sum of three elements is zero then print elements otherwise print not found.
     * Algorithm:
     * Run three nested loops with loop counter i, j, k
     * The first loops will run from 0 to n-3 and second loop from i+1 to n-2 and the third loop from j+1 to n-1.
     * The loop counter represents the three elements of the triplet.
     * Check if the sum of elements at i’th, j’th, k’th is equal to zero or not. If yes print the sum else continue.
     */
    static void findTriplets(int[] arr) {
        boolean found = false;
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
                        found = true;
                    }
                }
            }
        }
        if (found == false)
            System.out.println("Not exists");
    }
    /**
     * Method 2: Using hashing to arrive at the results, time complexity O(n^2)
     * This involves traversing the array. For every element arr[i], find a pair with sum "-arr[i]"
     * This problem reduces to pair sum and be solved in O(n) time using hashing.
     * Algorithm:
     * 1. Create a Hashmap to store a key-value pair
     * 2. Run a nested loop with two loops, the outer loop from 0 to n-2 and the inner loop from i+1 to n-1
     * 3. Check if the sum of ith and jth element multiplied with -1 is present in the hashmap or not.
     * 4. If the element is present in the hashmap, print the triplet else insert the jth element in the hashmap.
     *
     */
    static void findTriplets2(int[] arr) {
        boolean found = false;
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
        
            // find all pairs with sum equals to "-arr[i]"
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int x = -(arr[i] + arr[j]);
                if (set.contains(x)) {
                    System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
                    found = true;
                } else {
                    set.add(arr[j]);
                }
            }
        }
        if (found == false) {
            System.out.println("No Triplet Found\n");
        }
    }
    /**
     * For every element check that there is a pair whose sum is equal to the negative value of the element.
     * Algorithm:
     * 1. Sort the array in ascending order.
     * 2. Traverse the array from start to end.
     * 3. For every index i, create two variables l = i+1 and r = n-1
     * 4. Run a loop until l is less than r if the sum of array[i], array[l], array[r] is equal to zero
     *      then print the triplet and break the loop.
     * 5. If the sum is less than zero, then increment the value of l, by increasing the value of l the sum will increase
     *    as the array is sorted, so array[l+1] > array[l]
     * 6. If the sum is greater than zero, then decrement the value of r, by increasing the value of l, the sum will decrease sas the
     *      array is sorted, so array[r-1] < array[r]
     *
     *  Complexity Analysis:
     *
     * Time Complexity : O(n2).
     * Only two nested loops are required, so the time complexity is O(n2).
     * Auxiliary Space : O(1), no extra space is required, so the time complexity is constant.
     */
    static void findTriplets3(int[] arr) {
        boolean found = false;
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r) {
                if (x + arr[l] + arr[r] == 0) {
                    //print elements if it's sum is zero
                    System.out.print(x+" "+arr[l]+" "+arr[r]+"\n");
                    l++;
                    r--;
                    found = true;
                } else if (x + arr[l] + arr[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        if (found == false) {
            System.out.println("No Triplet Found");
        }
    }
}
