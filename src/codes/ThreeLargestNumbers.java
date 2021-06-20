import java.util.Arrays;

/**
 * Time complexity O(N)
 * Space complexity O(1)
 */
public class ThreeLargestNumbers {
    public static void main(String[] args) {
        int[] arr = {141,1,-7,-17,-27,18,541,8,7,7};//{10, 5, 9, 10, 12};
        System.out.println(Arrays.toString(findThreeLargestNumbers(arr)));
    }
    
        public static int[] findThreeLargestNumbers(int[] array) {
            int[] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
            for (int num : array) {
                updateLargest(threeLargest, num);
            }
            return threeLargest;
        }
    
        static void updateLargest(int[] threeLargest, int num) {
            if (num > threeLargest[2]) {
                shiftAndUpdate(threeLargest, num, 2);
            } else if (num > threeLargest[1]) {
                shiftAndUpdate(threeLargest, num, 1);
            } else if (num > threeLargest[0]) {
                shiftAndUpdate(threeLargest, num, 0);
            }
        }
        static void shiftAndUpdate(int[] array, int num, int idx) {
            for (int i = 0; i <= idx; i++) {
                if (i == idx)
                    array[i] = num;
                else {
                    array[i] = array[i + 1];
                }
            }
        }
}
