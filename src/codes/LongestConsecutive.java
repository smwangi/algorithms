import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Example:
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutive {
    public static void main(String[] args) {
    
        List<Integer> a = Arrays.asList(100, 4, 200, 1, 3, 2);
        System.out.println(longestConsecutive(a));
    }
    /**
     *  My really simple Java O(n) solution - Accepted
     *  We will use HashMap. The key thing is to keep track of the sequence length and store that in the
     *  boundary points of the sequence. For example, as a result, for sequence {1, 2, 3, 4, 5},
     *  map.get(1) and map.get(5) should both return 5.
     *
     *  Whenever a new element n is inserted into the map, do two things:
     *  See if n - 1 and n + 1 exist in the map, and if so, it means there is an existing sequence next to n.
     *  Variables left and right will be the length of those two sequences,
     *  while 0 means there is no sequence and n will be the boundary point later.
     *  Store (left + right + 1) as the associated value to key n into the map.
     *
     *  Use left and right to locate the other end of the sequences to the left and right of n respectively,
     *  and replace the value with the new length.
     *  Everything inside the for loop is O(1) so the total time is O(n).
     *  Please comment if you see something wrong. Thanks.
     */
    
    
    static int longestConsecutive(final List<Integer> a) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : a) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                int sum = left + right + 1;
                map.put(n, sum);
                // Keep track of the max length
                res = Math.max(res, sum);
                // extend the length to the boundary(s) of the sequence, will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                // duplicates
                continue;
            }
        }
        return res;
    }
}
