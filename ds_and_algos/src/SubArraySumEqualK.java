import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 *
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 *
 * Constraints:
 *
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubArraySumEqualK {
    public static void main(String[] args) {

        SubArraySumEqualK sumEqualK = new SubArraySumEqualK();
        int[] arr = {1,1,1};
        int k = 2;
        System.out.println(sumEqualK.subArraySum(arr,k));
        System.out.println(subarraySum(arr,k));
    }

    /**
     * Brute Force
     * The simplest method is to consider every possible subarray of the given nums array,
     * find the sum of the elements of each of those subarrays and check for the equality of the sum obtained with the given k.
     * Whenever the sum equals kkk, we can increment the count used to store the required result.
     */
    public static int subarraySum(int[] nums, int k){

        int count = 0;
        for(int i = 0; i< nums.length;i++){
            for(int j=i+1;j<= nums.length;j++){
                int sum = 0;
                for(int l = i; l<j;l++)
                    sum += nums[l];

                if(sum == k)
                    count++;
            }
        }
        return count;
    }
    /**
     * Algorithm
     *
     * The idea behind this approach is as follows: If the cumulative sum(represented by sum[i] for sum upto ith index)
     * upto two indices is the same, the sum of the elements lying in between those indices is zero.
     *
     * Extending the same thought further, if the cumulative sum upto two indices, say i and j is at a difference of k i.e.
     * if sum[i] - sum[j] = k, the sum of elements lying between indices i and j is k.
     *
     * Based on these thoughts, we make use of a hashmap map which is used to store the cumulative sum upto all the indices
     * possible along with the number of times the same sum occurs. We store the data in the form:
     * (sum i, no. of occurrences of sum i)
     *
     * We traverse over the array nums and keep on finding the cumulative sum.
     * Every time we encounter a new sum, we make a new entry in the hashmap corresponding to that sum.
     * If the same sum occurs again, we increment the count corresponding to that sum in the hashmap.
     * Further, for every sum encountered, we also determine the number of times the sum sum-k has occurred already,
     * since it will determine the number of times a sub array with sum k has occurred up to the current index.
     * We increment the count by the same amount.
     *
     * After the complete array has been traversed, the count gives the required result.
     *
     *
     * **Complexity Analysis**
     * Time complexity : O(n). The entire nums array is traversed only once.
     *
     * Space complexity : O(n). Hashmap map can contain up to n distinct entries in the worst case.
     * @param nums
     * @param k
     * @return
     */
    public int subArraySum(int[] nums, int k){
        int count = 0, sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i = 0; i< nums.length; i++){
            sum += nums[i];
            System.out.println(sum);
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return count;
    }
}
