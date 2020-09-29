package codes;

/**
 * Find maximum sum of subsequence with no adjustment elements
 *
 * Given an array of integers, find maximum sum of subsequences of given array  where subsequence
 * contains no adjustment elements.
 */
public class MaxSumSubsequence {

    public static void main(String[] args) {
        int[] arr = {1,2,9,4,5,0,4,11,6};
       System.out.println( maxSum(arr,0,arr.length,Integer.MIN_VALUE));
    }

    //i index of current element
    // prev index of previous element included in sum
    private static int maxSum(int[] arr,int i, int n, int prev){
        //base case: all elements are processed
        if(i == n)
            return 0;

        //recur by excluding the current element
        int excl = maxSum(arr,i+1,n,prev);
        int incl = 0;
        //include the current element if it is not adjacent to the previous element considered
        if(prev+1 != i)
            incl = maxSum(arr,i+1,n,i)+arr[i];

        //return the maximum sum we get by inc or excl current item
        return Integer.max(incl,excl);
    }
}
