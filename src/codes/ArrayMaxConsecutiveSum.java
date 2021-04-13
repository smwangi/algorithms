
public class ArrayMaxConsecutiveSum {
    public static void main(String[] args) {
        int[] arr = {-2,2,5,-11,6};

        int maxSum = arr[0];
        int currentSum = maxSum;

        for(int i = 1; i < arr.length; i++){
            currentSum = Math.max(arr[i] + currentSum, arr[i]);
            maxSum = Math.max(currentSum,maxSum);
        }

        System.out.println(maxSum);
    }
}
