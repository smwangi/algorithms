import java.util.*;

/**
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
 * If multiple values have the same frequency, sort them in decreasing order.
 *
 * Return the sorted array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 *
 * Example 2:
 *
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 *
 * Example 3:
 *
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 100
 *     -100 <= nums[i] <= 100
 */
public class SortArrByIncreasingFrequency {
    public static void main(String[] args) {

        int[]nums = {1,1,2,2,2,3};
        Arrays.stream(frequencySort(nums)).forEach(x->System.out.print(x+" "));
    }
    static int[] frequencySort(int[]nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Comparator<Map.Entry<Integer,Integer>>valueComparator=new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() == o2.getValue()?(o1.getKey() < o2.getKey() ? 1:-1):(o1.getValue() < o2.getValue()?-1:1);
            }
        };
        List<Map.Entry<Integer,Integer>>sortedList = new ArrayList<>(map.entrySet());
        Collections.sort(sortedList,valueComparator);
        int[]result = new int[nums.length];
        int i = 0;
        for (Map.Entry<Integer,Integer> e:sortedList){
            for (int j = 0;j<e.getValue();++j){
                result[i++] = e.getKey();
            }
        }
        return result;
    }
}
