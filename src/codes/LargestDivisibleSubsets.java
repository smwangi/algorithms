package codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DESCRIPTION:-
 *
 * Given an array the task is to largest divisible subset in array.
 * A subset is called divisible if for every pair (x, y) in subset, either x divides y or y divides x.
 *
 * Examples:
 *
 * Input : arr[] = {1, 16, 7, 8, 4}
 * Output : 16 8 4 1 or 1 4 8 16
 *
 * An efficient solution involves following steps.
 *
 * 1. Sort all array elements in increasing order. The purpose of sorting is to make sure that all
 *    divisors of an element appear before it.
 * 2. Create an array dp[] of same size as input array. dp[i] stores size of divisible
 *    subset ending with arr[i] (In sorted array). The minimum value of dp[i] would be 1.
 * 3. Traverse all array elements. For every element, find a divisor arr[j] with largest
 *    value of dp[j] and store the value of dp[i] as dp[j] + 1.
 */
public class LargestDivisibleSubsets {

    public static void main(String[] args) {
        int arr[] = {1,2,4,8};//{1, 16, 7, 8, 4};
        LargestDivisibleSubsets largestDivisibleSubsets = new LargestDivisibleSubsets();
        largestDivisibleSubsets.largestDivisibleSubset(arr).forEach(System.out::println);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] l = new int[nums.length]; // the length of largestDivisibleSubset that ends with element i
        int[] prev = new int[nums.length]; // the previous index of element i in the largestDivisibleSubset ends with element i

        Arrays.sort(nums);
        int max = 0;
        int index = -1;

        for(int i = 0; i < nums.length; i++){
            l[i] = 1;
            prev[i] = -1;
            for (int j = i-1; j >= 0; j--){
                if(nums[i] % nums[j] == 0 && l[j] +1 > l[i]){
                    l[i] = l[j]+1;
                    prev[i] = j;
                }
            }
            if(l[i] > max){
                max = l[i];
                index = i;
            }
        }
        List<Integer> subsets = new ArrayList<>();
        while (index != -1){
            subsets.add(nums[index]);
            index = prev[index];
        }
        return subsets;
    }
}
