package codes;

import java.util.Arrays;

/**
 * Given an array which contains even and odd integers. Write an algorithm to separate even and odd numbers.
 *
 * int [] arrA = {1,2,3,4,6,8,7,12};
 * Output: [12, 2, 8, 4, 6, 3, 7, 1]
 */
public class SeparateOddsAndEvens {

    public static void main(String[] args) {

        int[]arr = {1,2,3,4,6,8,7,12};
        separate(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Approach: Swapping Indexes
     *
     *     Use two indexes, left and right.
     *     Put left index at the start of array and right at the end of the array.
     *     Increment left till odd number is not found.
     *     Decrement right till even number is not found.
     *     Swap left and right elements
     *     Do it till left<right
     *
     * Time Complexity: O(n)
     * @param arr
     */
    private static void separate(int[] arr){
        //int[] res = new int[arr.length];
        int l = 0, r = arr.length-1;
        while (l < r){
            if(arr[r] % 2 == 0){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }else if(arr[l] % 2 !=0){
                int temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }
            l++;
            r--;
        }

       // return res;
    }
    //Alternative
    public static int[] arrange(int [] arrA){
        int left =0;
        int right = arrA.length-1;

        while(left<right){
            if(arrA[left]%2==0)
                left++;
            else if(arrA[right]%2==1)
                right--;
            else{
                //swap left and right elements
                int temp = arrA[left];
                arrA[left] = arrA[right];
                arrA[right] = temp;
                left++;
                right--;
            }
        }
        return arrA;
    }
}
