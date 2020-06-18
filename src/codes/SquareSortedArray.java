package codes;

import java.util.Arrays;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number,
 * also in sorted non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */
public class SquareSortedArray {
    public static void main(String[] args) {
        int[] A = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(A)));
    }

    private static int[] sortedSquares(int[] A) {
        int[] nums = new int[A.length];

        //Arrays.sort(A);
        //System.out.println(Arrays.toString(A));
        for (int i = 0; i < A.length; i++){
            nums[i] = A[i]*A[i];
        }
        Arrays.sort(nums);
        return  nums;
    }
}
