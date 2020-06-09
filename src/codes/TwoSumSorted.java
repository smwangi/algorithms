package codes;

import java.util.Arrays;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumSorted {

    public static void main(String[] args) {

       int[] arr =  {2,7,11,15};
        int target = 9;
        twoSum(arr,target);
    }
    static int[] twoSum(int[] arr, int target){
        int[]result = new int[2];

        for(int i = 0; i< arr.length;i++){
            for (int j = i+1;j<arr.length;j++){
                if(arr[i]+arr[j] == target){
                    result[0] = ++i;
                    result[1] = ++j;
                }
            }
        }
        //System.out.println(Arrays.toString(result));
        return result;
    }
}
