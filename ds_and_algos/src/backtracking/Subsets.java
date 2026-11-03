package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
 *
 * Backtracking: every node of the decision tree is a subset. A start index excludes the numbers
 * before it, so each combination is generated only once (see Permutations for the contrast).
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        backtrack(list, new ArrayList<>(), sorted, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
