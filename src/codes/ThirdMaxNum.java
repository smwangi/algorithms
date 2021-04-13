/**
 * Input: nums = [1,2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 *
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Can you find an O(n) solution?
 */
public class ThirdMaxNum {
    public static void main(String[] args) {

        int[]nums = {1,2};//{2,2,3,1};
       System.out.println(thirdMax(nums));
    }

    static int thirdMax(int[] nums){
        Integer max = null;
        Integer secondMax = null;
        Integer thirdMax = null;

        for (Integer num : nums){

            if(num.equals(max) || num.equals(secondMax) || num.equals(thirdMax)){
                continue;
            }

            if(max == null || num > max){
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            }else if(secondMax == null || num > secondMax){
                thirdMax = secondMax;
                secondMax = num;
            }else if(thirdMax == null || num > thirdMax){
                thirdMax = num;
            }
        }
        if(thirdMax == null)return max;
        return thirdMax;
    }
}
