package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return the indices of the two numbers such that
 * they add up to target. You may not use the same element twice. Return an empty array if there is no such pair.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 */
public class TwoSum {

	// Check every pair. O(n^2) time, O(1) space.
	public static int[] bruteForce(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		return new int[0];
	}

	/**
	 * One-pass Hash Table
	 * While we iterate and insert elements into the table, we also look back to check if the current
	 * element's complement already exists in the table. If it exists, we have found a solution and return immediately.
	 *
	 * Complexity Analysis:
	 *
	 * Time complexity : O(n). We traverse the list containing n elements only once.
	 * Each look up in the table costs only O(1) time.
	 *
	 * Space complexity : O(n). The extra space required depends on the number of items stored in the hash table,
	 * which stores at most n elements.
	 */
	public static int[] onePassHash(int[] nums, int target) {
		Map<Integer, Integer> seen = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			Integer complement = seen.get(target - nums[i]);
			if (complement != null) {
				return new int[]{complement, i};
			}
			seen.put(nums[i], i);
		}
		return new int[0];
	}

	/**
	 * Given an array A of integers and integer K, return the maximum S such that there exists i < j with
	 * A[i] + A[j] = S and S < K. If no i, j exist satisfying this equation, return -1.
	 *
	 * Input: A = [34,23,1,24,75,33,54,8], K = 60
	 * Output: 58 (34 + 24)
	 */
	public static int twoSumLessThanK(int[] A, int K) {
		int[] sorted = A.clone();
		Arrays.sort(sorted);
		// put pointers at begin/end
		int l = 0, r = sorted.length - 1;
		int ans = -1;
		while (l < r) {
			int curSum = sorted[l] + sorted[r];
			if (curSum < K) {
				ans = Math.max(ans, curSum);
				l++;
			} else {
				r--;
			}
		}
		return ans;
	}
}
