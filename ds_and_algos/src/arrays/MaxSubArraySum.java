package arrays;

public class MaxSubArraySum {
    // Kadane's algorithm: drop the running sum once it goes negative
    public int printMaxSubArrSum(int[] arr) {
        int sum = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(sum, max);

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
