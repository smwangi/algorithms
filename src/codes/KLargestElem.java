
import java.util.*;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KLargestElem {
    public static void main(String[] args) {
        //int[] nums = {3,2,3,1,2,4,5,5,6};
        //int k  = 4;

        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums,k));
        System.out.println(findKthLargestSorting(nums,k));
        int[]nums2 = {1, 23, 12, 9, 30, 2, 50};
        kLargest(nums,k);
        kthSmallest(nums,k);
    }

    /**
     * We can use a min heap to solve this problem.
     * The heap stores the top k largest elements.The top of the heap is the Kth Largest element and all other
     * elements are greater than the heap top. Whenever the size is greater than k, delete the min.
     * Time complexity is O(nlog(k)).
     * Space complexity is O(k) for storing the top k numbers.
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);

        for (int num : nums)
            queue.offer(num);

        while (k > 0){
            if(k == 1)
                return queue.poll();
            queue.poll();
            k--;
        }
            //System.out.println(queue.poll());
//
//        List<Integer>list = new ArrayList<>(queue);
//        //System.out.println(queue.toArray()[k]);
//
//        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
//        for(int i=0; i < nums.length; i++){
//            heap.add(nums[i]);
//        }
//        int max=0;
//        for(int i=1; i<=k; i++){
//            max=heap.poll();
//        }
//    System.out.println(max);
         return -1;
    }

    /**
     * You may assume k is always valid, 1 ≤ k ≤ array's length.
     * Time is O(nlog(n)). The problem of this solution is that sorting all elements is not necessary
     * and is a overkill for getting just one element.
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargestSorting(int[] nums, int k) {
        Arrays.sort(nums);

        System.out.println(nums.length-k);
        return nums[nums.length-k];
    }
    static void kLargest(int[] nums, int k){
        PriorityQueue<Integer>queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums)
            queue.add(num);
        while (k-- > 0)
            System.out.print(queue.poll()+" ");
    }

    static void kthSmallest(int[] nums,int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i< k;i++)
            queue.offer(nums[i]);
        for (int i = k; i < nums.length;i++){
            if(nums[i] < queue.peek()){
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        System.out.println("Smallest "+queue.peek());
    }
}
