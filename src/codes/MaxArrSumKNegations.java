import java.util.PriorityQueue;

/**
 * Maximize array sum after K negations | Set 2
 *
 * Given an array of size n and a number k. We must modify array K number of times.
 * Here modify array means in each operation we can replace any array element arr[i] by -arr[i].
 * We need to perform this operation in such a way that after K operations, sum of array must be maximum?
 *
 * Examples:
 *
 * Input : arr[] = {-2, 0, 5, -1, 2}
 *         K = 4
 * Output: 10
 * // Replace (-2) by -(-2), array becomes {2, 0, 5, -1, 2}
 * // Replace (-1) by -(-1), array becomes {2, 0, 5, 1, 2}
 * // Replace (0) by -(0), array becomes {2, 0, 5, 1, 2}
 * // Replace (0) by -(0), array becomes {2, 0, 5, 1, 2}
 *
 * Input : arr[] = {9, 8, 8, 5}
 *         K = 3
 * Output: 20
 */
public class MaxArrSumKNegations {
    public static void main(String[] args) {

        int[] arr = {-2, 0, 5, -1, 2};
        int k = 4;
        System.out.println(maxSum(arr, k));
    }

    /**
     * The idea used in above post is to replace the minimum element arr[i] in array by -arr[i] for current operation.
     * In this way we can make sum of array maximum after K operations. Once interesting case is,
     * once minimum element becomes 0, we don’t need to make any more changes.
     *
     * The implementation used in above solution uses linear search to find minimum element.
     * The time complexity of the above discussed solution is O(nk)
     *
     * In this post an optimized solution is implemented that uses a priority queue (or binary heap) to find minimum element quickly.
     * @param arr
     * @param k
     * @return
     */
    private static int maxSum(int[]arr,int k){
        //Create a PriorityQueue and insert all array elements
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int x : arr)priorityQueue.add(x);

        while (k-- > 0){
            int temp = priorityQueue.poll();

            temp *=-1;
            priorityQueue.add(temp);
        }
        //Compute sum of all elements in the priority queue
        int sum = 0;
        for (int x: priorityQueue)
            sum +=x;
        return sum;
    }
}
