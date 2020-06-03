package codes;

import java.util.Arrays;

/**
 * This is a demo task.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class DemoSolution {

    public static void main(String[] args) {

        int[] arr = {1,3,6,4,1,2};
        int num = solution(arr);
        System.out.println(num);
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int min = 1,cap = A.length;
        //Sort array 1,1,2,3,4,6
        Arrays.sort(A);
        for(int i = 0; i < cap; i++){
            if(A[i] == min){
                min++;
            }
        }
        return min;
    }
}
