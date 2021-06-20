import java.security.PublicKey;
import java.util.*;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 * Example 4:
 *
 * Input: candidates = [1], target = 1
 * Output: [[1]]
 * Example 5:
 *
 * Input: candidates = [1], target = 2
 * Output: [[1,1]]
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(arr, target).forEach(x -> System.out.println(x));
        System.out.println();
        combinationSum.combinationSum2(arr, target).forEach(x -> System.out.println(x));
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(6);
        arrayList.add(8);
        
        int sum = 8;
        ArrayList<ArrayList<Integer>> ans = combinationSum(arrayList, sum);
        if (ans.size() == 0) {
            System.out.println("Empty");
        }
        // print all combinations
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("(");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j)+ " ");
            }
            System.out.print(")");
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, int[] candidates, int target, List<Integer> prefix, int startAt) {
        if (target < 0)
            return;
        if (target == 0)
            result.add(new ArrayList<>(prefix));
        else {
            for (int i = startAt; i < candidates.length; i++) {
                prefix.add(candidates[i]);
                backtrack(result, candidates, target-candidates[i], prefix, i);
                prefix.remove(prefix.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, candidates, target, new ArrayList<Integer>(), 0);
        return result;
    }
    private void dfs(List<List<Integer>> result, int[] candidates, int target, List<Integer> combo, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(combo));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                combo.add(candidates[i]);
                dfs(result, candidates, target - candidates[i], combo, i);
                combo.remove(combo.size() - 1);
            }
        }
    }
    /**
     * Given an array of positive integers arr[] and a sum x, find all unique combinations in arr[] where the sum is equal to x. The same repeated number may be chosen from arr[] unlimited number of times. Elements in a combination (a1, a2, …, ak) must be printed in non-descending order. (ie, a1 <= a2 <= … <= ak).
     * The combinations themselves must be sorted in ascending order, i.e., the combination with smallest first element should be printed first. If there is no combination possible the print “Empty” (without quotes).
     *
     * Examples:
     * Input : arr[] = 2, 4, 6, 8
     *             x = 8
     * Output : [2, 2, 2, 2]
     *          [2, 2, 4]
     *          [2, 6]
     *          [4, 4]
     *          [8]
     *
     * Since the problem is to get all the possible results, not the best or the number of result, thus we don’t need to consider DP(dynamic programming), recursion is needed to handle it.
     *
     * We should use the following algorithm.
     * 1. Sort the array(non-decreasing).
     * 2. First remove all the duplicates from array.
     * 3. Then use recursion and backtracking to solve
     *    the problem.
     *    (A) If at any time sub-problem sum == 0 then
     *        add that array to the result (vector of
     *        vectors).
     *    (B) Else if sum is negative then ignore that
     *        sub-problem.
     *    (C) Else insert the present array in that
     *        index to the current vector and call
     *        the function with sum = sum-ar[index] and
     *        index = index, then pop that element from
     *        current index (backtrack) and call the
     *        function with sum = sum and index = index+1
     *
     */
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        // first do hashing since hashset does not always
        // sort
        //  removing the duplicates using HashSet and
        // Sorting the arrayList
        Set<Integer> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        Collections.sort(arr);
        findNumbers(ans, arr,sum, 0, temp);
        return ans;
    }
    static void findNumbers(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr, int sum, int index, ArrayList<Integer> temp) {
        if (sum == 0) {
            // Add deep copy of list to ans
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i= index; i < arr.size(); i++) {
            //checking that sum does not become negative
            if ((sum - arr.get(i)) >= 0) {
                // adding element which can contribute to sum
                temp.add(arr.get(i));
                findNumbers(ans, arr, sum - arr.get(i), i, temp);
                // removing the item from list (backtracking)
                temp.remove(arr.get(i));
            }
        }
    }
}
