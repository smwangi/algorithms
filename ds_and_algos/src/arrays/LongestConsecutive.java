package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * The elements do not have to be adjacent in the array.
 *
 * Example:
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Given {2, 0, 6, 1, 5, 3, 7},
 * The longest consecutive elements sequence is {0, 1, 2, 3}. Return its length: 4.
 *
 * A naive solution would be to sort the array and compare neighbours, which is O(n log n).
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutive {

    /**
     * Boundary map. The key thing is to keep track of the sequence length and store that in the
     * boundary points of the sequence. For example, for sequence {1, 2, 3, 4, 5},
     * map.get(1) and map.get(5) should both return 5.
     *
     * Whenever a new element n is inserted into the map, do two things:
     * See if n - 1 and n + 1 exist in the map, and if so, it means there is an existing sequence next to n.
     * Variables left and right will be the length of those two sequences,
     * while 0 means there is no sequence and n will be the boundary point later.
     * Store (left + right + 1) as the associated value to key n into the map.
     *
     * Use left and right to locate the other end of the sequences to the left and right of n respectively,
     * and replace the value with the new length.
     * Everything inside the for loop is O(1) so the total time is O(n).
     */
    public static int boundaryMap(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) continue; // duplicates
            int left = map.getOrDefault(n - 1, 0);
            int right = map.getOrDefault(n + 1, 0);
            int sum = left + right + 1;
            map.put(n, sum);
            // Keep track of the max length
            res = Math.max(res, sum);
            // extend the length to the boundary(s) of the sequence, will do nothing if n has no neighbors
            map.put(n - left, sum);
            map.put(n + right, sum);
        }
        return res;
    }

    /**
     * Set lookup. Put every element in a set, then only start counting from elements that begin a
     * sequence (e - 1 is not in the set), checking for e + 1, e + 2, ... in O(1) each.
     * Each element is visited at most twice, so the total time is O(n).
     */
    public static int setLookup(int[] nums) {
        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());
        int maxLen = 0;
        for (int e : set) {
            // `e` is a candidate for starting a sequence only if `e - 1` doesn't exist in the set
            if (!set.contains(e - 1)) {
                int len = 1;
                while (set.contains(e + len)) {
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
