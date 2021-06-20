/**
 * Print array after it is right rotated K times
 * Given an Array of size N and a values K, around which we need to right rotate the array. How to quickly print the right rotated array?
 *
 * Examples :
 *
 * Input: Array[] = {1, 3, 5, 7, 9}, K = 2.
 * Output: 7 9 1 3 5
 * Explanation:
 * After 1st rotation - {9, 1, 3, 5, 7}
 * After 2nd rotation - {7, 9, 1, 3, 5}
 *
 * Input: Array[] = {1, 2, 3, 4, 5}, K = 4.
 * Output: 2 3 4 5 1
 *
 * Approach:
 *
 * We will first take mod of K by N (K = K % N) because after every N rotations array will become the same as the initial array.
 * Now, we will iterate the array from i = 0 to i = N-1 and check,
 * If i < K, Print rightmost Kth element (a[N + i -K]). Otherwise,
 * Print array after ‘K’ elements (a[i – K]).
 */
public class RotateArrKtimes {
    public static void main(String[] args) {
        int Array[] = {1, 2, 3, 4, 5};
        int N = Array.length;
    
        int K = 2;
        rightRotate(Array, N, K);
    }
    static void rightRotate(int[] arr, int n, int k) {
        // If rotation is greater than size of array
        k = k % n;
        for (int i = 0; i < n; i++) {
            if (i < k) {
                // Printing the rightmost kth elements
                System.out.print(arr[n + i - k] + " ");
            } else {
                // Prints array after k elements
                System.out.print(arr[i - k] + " ");
            }
        }
        System.out.println();
    }
}
