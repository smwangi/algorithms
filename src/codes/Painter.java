/**
 * The painter’s partition problem | Set 2
 * We have to paint n boards of length {A1, A2, .. An}. There are k painters available and each takes 1 unit time to paint 1 unit of board.
 * The problem is to find the minimum time to get this job done under the constraints that any painter will only paint
 * continuous sections of boards, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
 *
 * Examples :
 *
 * Input : k = 2, A = {10, 10, 10, 10}
 * Output : 20.
 * Here we can divide the boards into 2
 * equal sized partitions, so each painter
 * gets 20 units of board and the total
 * time taken is 20.
 *
 * Input : k = 2, A = {10, 20, 30, 40}
 * Output : 60.
 * Here we can divide first 3 boards for
 * one painter and the last board for
 * second painter.
 *
 * In this post we will look into a more efficient approach using binary search. We know that the invariant of
 * binary search has two main parts:
 * * the target value would always be in the searching range.
 * * the searching range will decrease in each loop so that the termination can be reached.
 *
 * We also know that the values in this range must be in sorted order. Here our target value is the maximum sum of a contiguous
 * section in the optimal allocation of boards. Now how can we apply binary search for this? We can fix the possible low to high range for
 * the target value and narrow down our search to get the optimal allocation.
 *
 * We can see that the highest possible value in this range is the sum of all the elements in the array and this happens
 * when we allot 1 painter all the sections of the board. The lowest possible value of this range is the maximum value of the array max,
 * as in this allocation we can allot max to one painter and divide the other sections such
 * that the cost of them is less than or equal to max and as close as possible to max.
 * Now if we consider we use x painters in the above scenarios, it is obvious that as the value in the range increases,
 * the value of x decreases and vice-versa. From this we can find the target value when x=k and use a helper function to find x,
 * the minimum number of painters required when the maximum length of section a painter can paint is given.
 */
public class Painter {
    public static void main(String[] args) {
        int[] arr = {10, 10, 10, 10} ;//{1, 2, 3, 4, 5, 6, 7, 8, 9};
        // calculate the size of array
        int n = arr.length;
        int k = 2;
        System.out.println(partition(arr, n, k));
    }
    // Return maximum element from the Array
    static int getMax(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    // Return sum of elements in the Array
    static int getSum(int[] arr, int n) {
        int total = 0;
        for (int i = 0; i < n; i++)
            total += arr[i];
        return total;
    }
    // find minimum required painters for given max len
    // which is the maximum length a painter can paint
    static int numberOfPainters(int[] arr, int n, int maxLen) {
        int total = 0, numPainters = 1;
        for (int i = 0; i < n; i++) {
            total += arr[i];
            if (total > maxLen) {
                // for the next count
                total = arr[i];
                numPainters++;
            }
        }
        return numPainters;
    }
    static int partition(int[] arr, int n, int k) {
        int lo = getMax(arr, n);
        int hi = getSum(arr, n);
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int requiredPainters = numberOfPainters(arr, n, mid);
            // find better optimum in lower half
            // here mid is included because we may not get anything better
            if (requiredPainters <= k)
                hi = mid;
            // find better optimum in upper half here mid is excluded because it gives
            // required Painters > k, which is invalid
            else
                lo = mid + 1;
        }
        // required
        return lo;
    }
}
