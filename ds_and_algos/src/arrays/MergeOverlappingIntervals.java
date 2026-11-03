package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals.
 * Example:
 * input: [[1,3], [2,4], [6,8], [9,10]]
 * output: [[1,4], [6,8], [9,10]]
 * Explanation: We only have two overlapping intervals [1,3] and [2,4]. Since [2,4] is contained in [1,3], we can merge them into [1,4].
 *
 * Input: [[6,8], [1,9], [2,4], [4,7]]
 * output: [[1,9]]
 */
public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        Interval[] intervals = new Interval[4];
        intervals[0] = new Interval(6, 8);
        intervals[1] = new Interval(1, 9);
        intervals[2] = new Interval(2, 4);
        intervals[3] = new Interval(4, 7);
        mergeIntervals(intervals);

        System.out.println();

        Interval[] intervals2 = new Interval[4];
        intervals2[0] = new Interval(1, 3);
        intervals2[1] = new Interval(2, 4);
        intervals2[2] = new Interval(6, 8);
        intervals2[3] = new Interval(9, 10);
        mergeIntervals(intervals2);

        System.out.println();

        int[][] intervals3 = new int[][]{{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        merge(intervals3);

        System.out.println();

        int[][] intervals4 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge(intervals4);

        System.out.println();

        int[][] intervals5 = new int[][]{{1, 3}, {2, 4}, {5, 7}, {6, 8}};
        int[][] mergedIntervals = mergeUsingLinkedList(intervals5);
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }

        System.out.println();

        int[][] meetings = new int[][]{{9, 10}, {13, 15}, {12, 14}, {16, 17}};
        int[][] mergedMeetings = mergeUsingLinkedList(meetings);
        for (int[] meeting : mergedMeetings) {
            System.out.println(Arrays.toString(meeting));
        }
        System.out.println();
    }

    // BruteForce Approach
    // Sort the intervals based on the start time
    // Push the first interval into a stack
    // For each Interval
    //      If the current interval overlaps with the top of the stack, update the stack top with the ending time of the current interval
    //      If the current interval does not overlap with the top of the stack then push the current interval into the stack
    static void mergeIntervals(Interval[] intervals)   {
        if (intervals.length <= 0) {
            return;
        }

        // Create an empty stack on intervals
        Stack<Interval> stack = new Stack<>();
        // Sort the intervals based on the start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        // Push the first interval into the stack
        stack.push(intervals[0]);

        // Start from the next interval and merge if necessary
        for (int i = 1; i < intervals.length; i++) {
            // Get the top element
            Interval top = stack.peek();
            // If the current interval is not overlapping with the top of the stack, push it to the stack
            if (top.end < intervals[i].start) {
                stack.push(intervals[i]);
            } else if (top.end < intervals[i].end) { // Otherwise, update the ending time of the top element if the ending time of the current interval is greater
                top.end = intervals[i].end;
                stack.pop();
                stack.push(top);
            }
        }

        // Print the contents of stack
        while (!stack.isEmpty()) {
            Interval t = stack.pop();
            System.out.println("[" + t.start + ", " + t.end + "]");
        }

    }

    static int[][] merge(int[][] intervals)    {
        Stack<int[][]> stack = new Stack<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int s = intervals[0][0];
        int e = intervals[0][1];
        stack.push(new int[][]{ {s}, {e}});


        List<int[]> result = new Stack<>();
        result.add(intervals[0]);

        Stack<int[]> ss = new Stack<>();
        ss.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] topInterval = ss.peek();
            if (topInterval[1] < intervals[i][0]) {
                ss.push(intervals[i]);
            } else if (topInterval[1] < intervals[i][1]) {
                topInterval[1] = intervals[i][1];
                ss.pop();
                ss.push(topInterval);
            }
        }
        int[][] res = new int[ss.size()][2];
        for (int i = 0; i < ss.size(); i++) {
            int[] t = ss.pop();
            res[i][0] = t[0];
            res[i][1] = t[1];
            System.out.println("[" + t[0] + ", " + t[1] + "]");
        }
        while (!ss.isEmpty()) {
            int[] t = ss.pop();
            System.out.println("[" + t[0] + ", " + t[1] + "]");
        }
        Arrays.asList(ss);
        return new int[4][];
    }

    /**
     * The merge method sorts the intervals based on their starting points. It then iterated through the sorted intervals, merging them if they overlap.
     * The linked list is used to store the merged intervals efficiently allowing for easy addition and retrieval if the last element
     * @param intervals
     * @return
     */
    static int[][] mergeUsingLinkedList(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current interval does not overlap with previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0])  {
                merged.add(interval);
            } else {
                // otherwise, there is overlap, so we merge the current and previous intervals.
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
