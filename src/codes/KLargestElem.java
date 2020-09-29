package codes;

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
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k  = 4;

        System.out.println(findKthLargest(nums,k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        int result = 0;
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
}
