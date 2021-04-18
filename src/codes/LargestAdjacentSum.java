
/**
 * A function named largestAdjacentSum that iterates through an array computing the sum of adjacent elements
 * and returning the largest such sum.
 */
public class  LargestAdjacentSum {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,1,1,1};//{18, -12, 9, -10};//{1,2,3,4};
        adjacentSum(arr);
    }
    private static int adjacentSum(int[]arr){
        int sum = Integer.MIN_VALUE;
        for (int i = 0 ; i<arr.length-1;i++){
            if(arr[i] + arr[i+1] > sum)
                sum = (arr[i]+arr[i+1]);
        }
        System.out.println(sum);
        return sum;
    }
}
