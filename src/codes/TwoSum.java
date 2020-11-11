
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String... args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		
		int[]res = twoSum(nums, target);
		System.out.println(Arrays.toString(res));
		System.out.println(Arrays.toString(twoSumDP(nums,9)));
		//Arrays.asList(res).forEach(e -> System.out.println(e));
	}
	
	private static int[] twoSum(int[] nums, int target) {

		int[] res = new int[2];
		
		for(int i = 0;i<nums.length;i++) {
			
			for(int j=i+1;j<nums.length;j++) {
				//System.out.println(nums[i]+" - "+nums[j]);
				if(nums[i] + nums[j] == target) {
					res[0] = nums[i];
					res[1] = nums[j];
				}
			}
		}
		
		return res;
	}

	/**
	 * One-pass Hash Table
	 * It turns out we can do it in one-pass. While we iterate and inserting elements into the table,
	 * we also look back to check if current element's complement already exists in the table.
	 * If it exists, we have found a solution and return immediately.
	 * @param nums
	 * @param target
	 * @return
	 *
	 * Complexity Analysis:
	 *
	 * Time complexity : O(n)O(n). We traverse the list containing nn elements only once.
	 * Each look up in the table costs only O(1)O(1) time.
	 *
	 * Space complexity : O(n)O(n). The extra space required depends on the number of items stored in the hash table,
	 * which stores at most nn elements.
	 */
	private static int[] twoSumDP(int[] nums, int target){
		Map<Integer, Integer> map = new HashMap<>();

		/*for(int i =0; i < nums.length; i++){

			if(map.containsKey(target - nums[i])){
				return new int[]{map.get(target-nums[i]),i};
			}else{
				map.put(nums[i],i);
			}
		}
		return new int[0];*/
		for(int i = 0; i< nums.length; i++){
			if(map.containsKey(target-nums[i])){
				return new int[]{map.get(target-nums[i]),i};
			}else{
				map.put(nums[i],i);
			}
		}
		return new int[0];
	}
 }
