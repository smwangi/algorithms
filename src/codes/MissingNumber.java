import java.util.Arrays;

/**
 * Given an array K with N integers from 1 to N+1 such that the array has exactly one integer missing, write
 * a Java function that returns the missing integer.
 * e.g. given K = [3,5,4,1], the function should return 2
 */
public class MissingNumber {
    public static void main(String[] args) {

        int[] arr = {7,5,1,3,2,6};// {3,5,4,1};
        System.out.println(missingNum(arr));
    }

    /**
     * Sort the array of numbers.
     * check if current value + 1 (arr[i]+1 = arr[i+1] (value in the next index))
     * if not return value in current index + 1
     * @param arr
     * @return
     */
    static int missingNum(int[] arr){
        if(arr.length == 0) return 0;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length;i++){
            if(arr[i]+1 == arr[i+1])
                continue;
            else return arr[i]+1;
        }
        return 0;
    }
    
    /**
     * Input: numbers={1,2,3,5,6}
     * Output: 4
     * numbers={1,3,2,5,6}
     * Output: 4
     * Approach:
     * Sort an Array using Arrays.sort(arr).
     * Since Array is sorted, we can compare the array indexes with the values.
     * If anyone of the array value not equal to array Index, then we can say that, that is a missed number.
     */
    static int getMissingNumber(int[] nums) {
        Arrays.sort(nums);
        int missed = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = i + 1;
            if(nums[i] != index) {
                missed = index;
                break;
            }
        }
        return missed;
    }
    
    /**
     * Find a missing number in an array (Un-Sorted)
     * (n+1)*(n+2)/2
     * @param nums
     * @return
     */
    static int getMissingNumber2(int[] nums) {
        int n = nums.length;
        int total = (n+1)*(n+2)/2;
        
        for (int i = 0; i < nums.length; i++) {
            total -= nums[i];
        }
        return total;
    }
}
