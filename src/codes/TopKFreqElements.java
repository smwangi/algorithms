
import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Note:
 *
 *     You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 *     Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *     It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 *     You can return the answer in any order.
 */
public class TopKFreqElements {

    public static void main(String[] args) {
        TopKFreqElements kFreqElements = new TopKFreqElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        kFreqElements.topKFrequent(nums,k);
        System.out.println(Arrays.toString(topKFrequent2(nums, k)));
    }

    public int[] topKFrequentX(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[k];

        for (int i = 0; i < nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        map.entrySet().stream().forEach(a -> System.out.println(a.getKey()+" "+a.getValue()));

        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((a,b) -> b.getValue().compareTo(a.getValue()));//Comparator.comparingInt(Map.Entry::getValue)
        for(Map.Entry entry : map.entrySet())
            queue.offer(entry);

        while (!queue.isEmpty()){
            Map.Entry<Integer,Integer> temp = queue.poll();
            if(k-- > 0){
                res[k] = temp.getKey();
            }
            if(k == 0)break;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for(int e : map.keySet()) {
            minHeap.add(e);
            if(minHeap.size() > k) minHeap.poll();
        }

        for(int i = 0; i < k; i++) {
            result[i] =  minHeap.poll();
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
    
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, (n1, n2) -> map.get(n2).compareTo(map.get(n1)));
        
        for (int num : map.keySet()) {
            pq.add(num);
        }
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
    
    public int[] topKFrequent3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((n1, n2) -> n1.getValue() - n2.getValue());
        for (Map.Entry<Integer, Integer> en : map.entrySet())  {
            pq.add(en);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i] = pq.poll().getKey();
            i++;
        }
        return res;
    }
}
