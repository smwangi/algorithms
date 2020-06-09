package codes;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int m = 3,n = 3;
        int[] nums2 = {2,5,6};
        System.out.println(Arrays.toString(mergedSorted(nums1,m,nums2,n)));
    }

    private static int[] mergedSorted(int[]nums1, int m, int[] nums2, int n){
        for(int i = m, j= 0; i < nums1.length; i++,j++)
            nums1[i] = nums2[j];

        Arrays.sort(nums1);
        return nums1;
    }
}
