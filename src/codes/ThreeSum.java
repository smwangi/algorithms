package codes;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * Hide Hint #1
 * So, we essentially need to find three numbers x, y, and z such that they add up to the given value. If we fix one of the numbers say x, we are left with the two-sum problem at hand!
 *    Hide Hint #2
 * For the two-sum problem, if we fix one of the numbers, say
 *
 * x
 *
 * , we have to scan the entire array to find the next number
 *
 * y
 *
 * which is
 *
 * value - x
 *
 * where value is the input parameter. Can we change our array somehow so that this search becomes faster?
 *    Hide Hint #3
 * The second train of thought for two-sum is, without changing the array, can we use additional space somehow? Like maybe a hash map to speed up the search?
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum sum = new ThreeSum();
        int[]arr = {3,0,-2,-1,1,2};
        sum.threeSumz(arr).forEach(x -> System.out.println(x));
    }

    private List<List<Integer>> threeSums(int[]nums){
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();

        for(int i = 0; i < nums.length;i++){
            //int current = nums[i];
            int l = i+1;
            int r =  nums.length -1;
            while(l < r){
                int currentSum = nums[i]+nums[l]+nums[r];
                if(currentSum == 0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r--]));
                }else if(currentSum > 0)r--;
                else if(currentSum < 0) l++;
            }

        }
        return new ArrayList<>(res);
    }

    private List<List<Integer>> threeSumz(int[] nums){
        Set<List<Integer>> triplets = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int left = i + 1;
            int right = nums.length-1;
            while(left < right) {
                int current = nums[i] + nums[left] + nums[right];
                if (current == 0) {
                    List<Integer> triplet = new LinkedList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    if (!triplets.contains(triplet)) {
                        triplets.add(triplet);
                    }

                    right--;
                } else {
                    if (current > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (List<Integer> list : triplets) {
            result.add(list);
        }
        return result;
    }
}
