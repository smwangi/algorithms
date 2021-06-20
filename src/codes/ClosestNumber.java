/**
 * Find closest number in array
 * Given an array of sorted integers. We need to find the closest value to the given number.
 * Array may contain duplicate values and negative numbers.
 *
 * Examples:
 *
 * Input : arr[] = {1, 2, 4, 5, 6, 6, 8, 9}
 *              Target number = 11
 * Output : 9
 * 9 is closest to 11 in given array
 *
 * Input :arr[] = {2, 5, 6, 7, 8, 8, 9};
 *        Target number = 4
 * Output : 5
 * Recommended: Please try your approach on {IDE} first, before moving on to the solution.
 *
 *
 * A simple solution is to traverse through the given array and keep track of absolute difference of current element with every element.
 * Finally return the element that has minimum absolution difference.
 *
 * An efficient solution is to use Binary Search.
 */
public class ClosestNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 6, 8, 9};
        int target = 11;
        System.out.println(findClosest(arr, target));
    }
    static int findClosest(int[] arr, int target) {
        int n = arr.length;
        // Corner cases
        if (target <= arr[0])
            return arr[0];
        if (target >= arr[n-1])
            return arr[n-1];
        
        //Binary search
        int i = 0, j = n, mid = 0;
        while (i < j) {
            mid = i + (j - i) / 2;
            if (arr[mid] == target)
                return arr[mid];
            // if target less than array element, then search in left
            if (target < arr[mid]) {
                // if target is greater than previous to mid, return closest of two
                if (mid > 0 && target > arr[mid - 1])
                    return getClosest(arr[mid - 1], arr[mid], target);
                // repeat for left half
                j = mid;
            } else { // if target is greater than mid
                if (mid < n - 1 && target < arr[mid + 1])
                    return getClosest(arr[mid], arr[mid + 1], target);
                i = mid + 1; //update i
            }
        }
        // Only single element left after search
        return arr[mid];
    }
    
    // Method to compare which one is the more close
    // We find the closest by taking the difference
    //  between the target and both values. It assumes
    // that val2 is greater than val1 and target lies
    // between these two.
    public static int getClosest(int val1, int val2, int target) {
        if (target - val1 >= val2 - target)
            return val2;
        else
            return val1;
    }
}
