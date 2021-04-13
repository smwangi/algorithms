import java.util.*;
/**
 * NextPermutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * Analysis
 *   The steps to solve this problem:
 *   1) scan from right to left, find the first element that is less than its previous one.

 *  4 5 6 3 2 1 
    |
    p
    
    2) scan from right to left, find the first element that is greater than p.

    4 5 6 3 2 1 
        |
        q
    
        3) swap p and q

    4 5 6 3 2 1 
    swap
    4 6 5 3 2 1 
    
    4) reverse elements [p+1, nums.length]

    4 6 1 2 3 5 
 */
public class NextPermutation {

    public static void main(String[] args) {
        
        int[]arr = {1,2,3};//{2, 3,  1};
        nextPermitation(arr);
        nextPermutation(arr);
    }

    static void nextPermitation(int[] arr){
        //find decreasing digit
        int mark = -1;
        for(int i = arr.length-1; i> 0;i--){
            //System.out.print(arr[i]+" "+arr[i-1]+" ");
            if(arr[i] > arr[i-1]){
                mark = i-1;
                break;
            }
            
        }
        
        if(mark == -1){
            reverse(arr, 0, arr.length-1);
            return;
        }

        int index = arr.length-1;
        for(int i= arr.length-1; i >= mark+1;i--){
            if(arr[i] > arr[mark]){
                index = i;
                break;
            }
        }
        swap(arr, mark, index);
        //System.out.println(mark+1+" "+index);
        reverse(arr, mark+1, arr.length-1);
        System.out.print(Arrays.toString(arr));
        

    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(int[] arr,int i, int j){
        while(i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    static void reverse1(int[] arr){
        int[] temp = new int[arr.length];
    }
    
    /**
     * Single Pass Approach
     * First, we observe that for any given sequence that is in descending order, no next larger permutation is possible. For example, no next permutation is possible for the following array:
     *
     * [9, 5, 4, 3, 1]
     * We need to find the first pair of two successive numbers a[i]a[i] and a[i-1]a[i−1], from the right,
     * which satisfy a[i] > a[i-1]a[i]>a[i−1]. Now, no rearrangements to the right of a[i-1]a[i−1]
     * can create a larger permutation since that subarray consists of numbers in descending order.
     * Thus, we need to rearrange the numbers to the right of a[i-1]a[i−1] including itself.
     *
     * Now, what kind of rearrangement will produce the next larger number?
     * We want to create the permutation just larger than the current one.
     * Therefore, we need to replace the number a[i-1]a[i−1] with the number which is just larger than
     * itself among the numbers lying to its right section, say a[j]a[j].
     *
     * We swap the numbers a[i-1]a[i−1] and a[j]a[j]. We now have the correct number at index i-1i−1. But still the current permutation isn't the permutation that we are looking for. We need the smallest permutation that can be formed by using the numbers only to the right of a[i-1]a[i−1]. Therefore, we need to place those numbers in ascending order to get their smallest permutation.
     *
     * But, recall that while scanning the numbers from the right, we simply kept decrementing the index until we found the pair a[i]a[i] and a[i-1]a[i−1] where, a[i] > a[i-1]a[i]>a[i−1]. Thus, all numbers to the right of a[i-1]a[i−1] were already sorted in descending order. Furthermore, swapping a[i-1]a[i−1] and a[j]a[j] didn't change that order. Therefore, we simply need to reverse the numbers following a[i-1]a[i−1] to get the next smallest lexicographic permutation.
     *
     * The following animation will make things clearer:
     */
    
    static void nextPermutation(int[] nums) {
        int i  = nums.length - 2;
        
        while ( i >= 0 && nums[i + 1] < nums[i]) {
            i--;
        }
        
        if(i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse2(nums, i + 1);
    }
    
    static void reverse2(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}