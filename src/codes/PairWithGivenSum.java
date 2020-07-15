package codes;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of positive integers nums and an int target, return indices of the two numbers such that they add up to a target - 30.
 *
 * Conditions:
 *
 * You will pick exactly 2 numbers.
 * You cannot pick the same element twice.
 * If you have multiple pairs, select the pair with the largest number.
 *
 * Example 1:
 *
 * Input: nums = [1, 10, 25, 35, 60], target = 90
 * Output: [2, 3]
 * Explanation:
 * nums[2] + nums[3] = 25 + 35 = 60 = 90 - 30
 *
 * Example 2:
 *
 * Input: nums = [20, 50, 40, 25, 30, 10], target = 90
 * Output: [1, 5]
 * Explanation:
 * nums[0] + nums[2] = 20 + 40 = 60 = 90 - 30
 * nums[1] + nums[5] = 50 + 10 = 60 = 90 - 30
 * You should return the pair with the largest number.
 */
public class PairWithGivenSum {

    public static void main(String[] args) {
        int target = 90;
        int[] arr = {20, 50, 40, 25, 30, 10};
        pairWithGivenSum(arr,target);
    }

    static void pairWithGivenSum(int[] arr, int target){
        int[] res = new int[arr.length];
        Map<Integer,Integer> indices = new HashMap<>();
        int newTarget = target - 30;
        for(int i = 0; i < arr.length; i++){
            for (int j = i+1; j<arr.length;j++){
                if(arr[i]+arr[j] == newTarget){
                    indices.put(i,j);
                }
            }
        }
        indices.entrySet().stream().forEach(System.out::println);
    }
}
