package codes;

import java.util.Arrays;

public class TwoSum {

	public static void main(String... args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		
		int[]res = twoSum(nums, target);
		System.out.println(Arrays.toString(res));
		//Arrays.asList(res).forEach(e -> System.out.println(e));
	}
	
	private static int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		
		for(int i = 0;i<nums.length;i++) {
			
			for(int j=i+1;j<nums.length;j++) {
				System.out.println(nums[i]+" - "+nums[j]);
				if(nums[i] + nums[j] == target) {
					res[0] = nums[i];
					res[1] = nums[j];
				}
			}
		}
		
		return res;
	}
}
