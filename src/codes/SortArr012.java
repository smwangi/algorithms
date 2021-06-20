import java.util.Arrays;

/**
 * Given an array A[] consisting 0s, 1s and 2s. The task is to write a function that sorts the given array.
 * The functions should put all 0s first, then all 1s and all 2s in last.
 * Examples:
 *
 *
 * Input: {0, 1, 2, 0, 1, 2}
 * Output: {0, 0, 1, 1, 2, 2}
 *
 * Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
 * Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 */
public class SortArr012 {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int arr_size = arr.length;
        sort012(arr, arr_size);
        System.out.println("Array after seggregation ");
        //System.out.println(Arrays.toString(sort012(arr, arr_size)));
    }
    /**
     * Approach:The problem is similar to our old post Segregate 0s and 1s in an array, and both of these problems are variation of famous Dutch national flag problem.
     * The problem was posed with three colours, here `0′, `1′ and `2′. The array is divided into four sections:
     * a[1..Lo-1] zeroes (red)
     * a[Lo..Mid-1] ones (white)
     * a[Mid..Hi] unknown
     * a[Hi+1..N] twos (blue)
     * If the ith element is 0 then swap the element to the low range, thus shrinking the unknown range.
     * Similarly, if the element is 1 then keep it as it is but shrink the unknown range.
     * If the element is 2 then swap it with an element in high range.
     * Algorithm:
     * Keep three indices low = 1, mid = 1 and high = N and there are four ranges, 1 to low (the range containing 0), low to mid (the range containing 1), mid to high (the range containing unknown elements) and high to N (the range containing 2).
     * Traverse the array from start to end and mid is less than high. (Loop counter is i)
     * If the element is 0 then swap the element with the element at index low and update low = low + 1 and mid = mid + 1
     * If the element is 1 then update mid = mid + 1
     * If the element is 2 then swap the element with the element at index high and update high = high – 1 and update i = i – 1. As the swapped element is not processed
     * Print the output array.
     * Dry Run:
     * Part way through the process, some red, white and blue elements are known and are in the “right” place. The section of unknown elements, a[Mid..Hi], is shrunk by examining a[Mid]:
     *
     * Examine a[Mid]. There are three possibilities:
     * a[Mid] is (0) red, (1) white or (2) blue.
     * Case (0) a[Mid] is red, swap a[Lo] and a[Mid]; Lo++; Mid++
     */
    static void sort012(int[] a, int arr_size) {
        int lo = 0;
        int hi = arr_size - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            switch (a[mid]) {
                case 0:{
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2:{
                    temp = a[mid];
                    a[mid] = a[hi];
                    a[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
    }
}
