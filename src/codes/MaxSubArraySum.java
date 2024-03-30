public class MaxSubArraySum {
    public int printMaxSubArrSum(int[] arr) {
        int sum = 0, max = Integer.MIN_VALUE;
        int l = 0, r = 0;

        while (l < arr.length) {
            sum = arr[l];
            while (r < arr.length - 1) {
                sum += arr[++r];
                if (sum > max) {
                    max = Math.max(sum, max);
                }
            }
            l++;
            r = l;
        }
        /*for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(sum, max);

            if (sum < 0) {
                sum = 0;
            }
        }*/

        return max;
    }
}
