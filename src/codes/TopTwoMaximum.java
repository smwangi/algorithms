public class TopTwoMaximum {
    public static void main(String[] args) {
    int[] nums = {1,16, 30, 56, 900};
     topTwo(nums);
    }
    /**
     * Now we iterate through the array and compare each number against these two numbers,
     * if the current number is greater than max1 then max1 = number and max2 = max1. Otherwise if it only greater than max2 then we only update max2 with the current number.
     *
     * Read more: https://www.java67.com/2014/03/how-to-find-top-two-maximum-number-from-integer-array-java.html#ixzz6rjSfXhLk
     */
    public static void topTwo(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        System.out.println("Max 1: "+max1+" Max 2: "+max2);
    }
}
