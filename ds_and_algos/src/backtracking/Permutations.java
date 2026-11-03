package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations, in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * The backtracking template is the same as for combinations and subsets, but the trees differ: the
 * permutation tree is symmetrical, while the combination tree has fewer right nodes. Permutations exclude
 * already-chosen numbers with a "used" check, while combinations and subsets pass a start index to
 * exclude the numbers before it. Keeping the shape of these trees in mind is enough to deal with most
 * backtracking problems. It is nothing more than the pruning of start or contains.
 */
public class Permutations {

    // Backtracking: extend the path with every number not already on it, undo, try the next.
    public static List<List<Integer>> backtrack(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new LinkedList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, boolean[] used, LinkedList<Integer> track, List<List<Integer>> result) {
        // trigger the ending condition
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // exclude illegal selection
            if (used[i]) continue;
            // select
            used[i] = true;
            track.add(nums[i]);
            // go to the next decision tree
            backtrack(nums, used, track, result);
            // deselect
            track.removeLast();
            used[i] = false;
        }
    }

    /**
     * Swap in place. At each position, swap every later element into the start index and recurse on the
     * next index; swap back afterwards so the array is restored for the next iteration. Whenever the
     * recursion reaches the end of the array, record the current order.
     */
    public static List<List<Integer>> bySwapping(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        bySwapping(nums.clone(), 0, result);
        return result;
    }

    private static void bySwapping(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(toList(nums));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            bySwapping(nums, start + 1, result);
            swap(nums, i, start);
        }
    }

    // Build each permutation by picking every element as the head and permuting the rest, copying lists as we go.
    public static List<List<Integer>> pickHead(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        pickHead(array, new ArrayList<>(), result);
        return result;
    }

    private static void pickHead(List<Integer> remaining, List<Integer> current, List<List<Integer>> result) {
        if (remaining.isEmpty()) {
            if (!current.isEmpty()) result.add(current);
            return;
        }
        for (int i = 0; i < remaining.size(); i++) {
            List<Integer> rest = new ArrayList<>(remaining);
            rest.remove(i);
            List<Integer> next = new ArrayList<>(current);
            next.add(remaining.get(i));
            pickHead(rest, next, result);
        }
    }

    /**
     * Heap's algorithm generates every permutation with a single swap between consecutive outputs:
     * for each n, permute the first n - 1, then swap the last element with either the i-th (n even)
     * or the first (n odd).
     */
    public static List<List<Integer>> heaps(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        heaps(nums.clone(), nums.length, result);
        return result;
    }

    private static void heaps(int[] arr, int n, List<List<Integer>> result) {
        if (n <= 1) {
            result.add(toList(arr));
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            heaps(arr, n - 1, result);
            if (n % 2 == 0) {
                swap(arr, i, n - 1);
            } else {
                swap(arr, 0, n - 1);
            }
        }
        heaps(arr, n - 1, result);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<>(arr.length);
        Arrays.stream(arr).forEach(list::add);
        return list;
    }
}
