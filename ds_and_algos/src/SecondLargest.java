/**
 * Find Second largest element in an array
 *
 * Given an array arr[] consisting of N integers, the task is to find the second largest element in the given array using
 * N+log2(N) – 2 comparisons.
 *
 * Examples:
 *
 * Input : arr[] = {22, 33, 14, 55, 100, 12}
 * Output : 55
 *
 *  Input : arr[] = {35, 23, 12, 35, 19, 100}
 * Output : 35
 *
 * Efficient Approach:
 * Follow the steps below to solve the problem:
 *
 * Find the largest element from the given array and keep track of all the elements compared with the largest element.
 * Split the current array into two equal length subarrays.
 * For each subarray, recursively find the largest element, and return an array in which the first index contains the length of this array,
 * second index element contains the largest element and the remaining array contains the elements with which the largest element
 * has been compared.
 * Now, from the two arrays returned by both the subarrays, compare the largest element of both the subarrays and return the array that
 * contains the largest of the two.
 * The final array returned by the findLargest() contains its size in the first index, the largest element of the array at the second index,
 * and the elements compared with the largest element in the remaining indices. Repeat the above steps using the findLargest()
 * to find the second largest element of the array from the list of compared elements.
 * Analysis Of Algorithm:
 * It is clearly visible from the algorithm that the time complexity of the findLargest() algorithm is O(N) [N: size of the array]
 * Hence, (N-1) comparisons are performed.
 * Now, the size of the array returned by findLargest() is log2(N) + 2, out of which log2(N) elements are the ones with which the
 * largest element is compared.
 * Hence, to find the second largest element, the largest among these log2(N) elements is calculated using log2(N) – 1 comparisons.
 *
 * Therefore, the total number of comparisons = N – 1 + log2(N) – 1 = N + log2(N) – 2
 */
public class SecondLargest {
    public static void main(String[] args) {
        int N = 10;
        int []arr ={20, 1990, 12, 1110, 1,
                59, 12, 15, 120, 1110};
        findSecondLargest(N, arr);
    }
    static int[] findLargest(int beg, int end, int[] arr, int n) {
        if (beg == end) {
            // initialize an empty list
            int[] compared = new int[n];
            compared[0] = 1;
            compared[1] = arr[beg];
            return compared;
        }

        // Divide the array into two equal
        // length subarrays and recursively
        // find the largest among the two
        int[] compared1 = findLargest(beg, (beg+end) / 2, arr, n);
        int[] compared2 = findLargest((beg+end) / 2 + 1, end, arr, n);
        if (compared1[1] > compared2[1]) {
            int k = compared1[0] + 1;
            // Store length of compared[] in the first index
            compared1[0] = k;
            // Store the maximum element
            compared1[k] = compared2[1];
            // Return compared1 which contains the maximum element
            return compared1;
        } else {
            int k = compared2[0] + 1;
            // Store length of compared2[] in the first index
            compared2[0] = k;
            // Store the maximum element
            compared2[k] = compared1[1];
            // Return compared2[] which contains the maximum element
            return compared2;
        }
    }
    // Function to print the second largest
    // element in the array arr[]
    static void findSecondLargest(int end, int[] arr) {
        // Find the largest in arr[]
        int[] compared1 = findLargest(0, end - 1, arr, end);
        // Find the second largest element in arr[]
        int[] compared2 = findLargest(2, compared1[0] + 2, compared1, compared1[0]);
        // Print the second largest element
        System.out.print(compared2[1]);
    }
}
