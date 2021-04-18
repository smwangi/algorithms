import java.util.PriorityQueue;

/**
 *
 Find the closest pair from two sorted arrays

 Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.

 We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to find the pair ar1[i] + ar2[j]
 such that absolute value of (ar1[i] + ar2[j] – x) is minimum.

 Example:

 Input:  ar1[] = {1, 4, 5, 7};
 ar2[] = {10, 20, 30, 40};
 x = 32
 Output:  1 and 30

 Input:  ar1[] = {1, 4, 5, 7};
 ar2[] = {10, 20, 30, 40};
 x = 50
 Output:  7 and 40

 */
public class ClosestPairofSortedArrays {

    public static void main(String[] args) {

      int  ar1[] = {1, 4, 5, 7};
      int  ar2[] = {10, 20, 30, 40};
      int x = 32;
      //int  ar1[] = {1, 4, 5, 7};
      // int ar2[] = {10, 20, 30, 40};
      //int x = 50;


      closestPair(ar1,ar2,x);
      printClosest(ar1,ar2,x);
      int[]a = {1, 23, 12, 9, 30, 2, 50};
      int n = 3;
      test(a,n);
    }

    /**
     * A Simple Solution is to run two loops. The outer loop considers every element of first array and inner loop checks for the pair in second array.
     * We keep track of minimum difference between ar1[i] + ar2[j] and x.
     * @param arr1
     * @param arr2
     * @param x
     */
    static void closestPair(int[] arr1, int[]arr2,int x ){

        int z =0 ,y = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr2.length; j++){
                int t = Math.abs((arr1[i] + arr2[j]) - x);

                if(t < min){
                    min = t;
                    z = arr1[i];
                    y = arr2[j];
                }

            }
        }
        System.out.println(z+" and "+y);
    }

    /**
     * We can do it in O(n) time using following steps.
     * 1) Merge given two arrays into an auxiliary array of size m+n using merge process of merge sort.
     * While merging keep another boolean array of size m+n to indicate whether the current element in merged array is from ar1[] or ar2[].
     *
     * 2) Consider the merged array and use the linear time algorithm to find the pair with sum closest to x.
     * One extra thing we need to consider only those pairs which have one element from ar1[] and other from ar2[], we use the boolean array for this purpose.
     *
     *
     * Can we do it in a single pass and O(1) extra space?
     * The idea is to start from left side of one array and right side of another array, and use the algorithm same as step 2 of above approach. Following is detailed algorithm.
     *
     * 1) Initialize a variable diff as infinite (Diff is used to store the
     *    difference between pair and x).  We need to find the minimum diff.
     * 2) Initialize two index variables l and r in the given sorted array.
     *        (a) Initialize first to the leftmost index in ar1:  l = 0
     *        (b) Initialize second  the rightmost index in ar2:  r = n-1
     * 3) Loop while  l = 0
     *        (a) If  abs(ar1[l] + ar2[r] - sum) < diff  then
     *            update diff and result
     *        (b) If (ar1[l] + ar2[r] <  sum )  then l++
     *        (c) Else r--
     * 4) Print the result.
     */
    private static void printClosest(int[] arr1, int[] arr2, int x){
        int m = arr1.length;
        int n = arr2.length;
        // Initialize the diff between pair sum and x.
        int diff  = Integer.MAX_VALUE;

        // res_l and res_r are result indexes from ar1[] and ar2[] respectively
        int res_l = 0, res_r = 0;

        // Start from left side of ar1[] and right side of ar2[]
        int l = 0,r = n-1;

        while (l < m && r >= 0){
            // If this pair is closer to x than the previously
            // found closest, then update res_l, res_r and diff
            if(Math.abs(arr1[l] + arr2[r] -x ) < diff){
                res_l = l;
                res_r = r;
                diff = Math.abs(arr1[l]+arr2[r] -x);
            }

            // If sum of this pair is more than x, move to smaller side
            if(Math.abs(arr1[l]+ arr2[r]) > x){
                r--;
            }else{//Move to greater side
                l++;
            }
        }

        System.out.println(arr1[res_l]+" and "+arr2[res_r]);
    }

    static void test(int[] arr, int n){
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        for (int i : arr)
            queue.offer(i);

        //for (int i = 0; i < n; i++)
        //    System.out.println(queue.poll());
        while (n >0){
            System.out.println(queue.poll());
            n--;
        }
    }
}
