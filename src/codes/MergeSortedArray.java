
import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {

        int[] nums1 = { 3, 7 };//{1, 5, 9, 10, 15, 20};//{1, 2, 3, 0, 0, 0};
        int m = 3, n = 3;
        int[] nums2 = { 4, 8, 11 };//{2, 3, 8, 13};//{2,5,6};
        System.out.println(Arrays.toString(mergedSorted(nums1,m,nums2,n)));
        System.out.println(Arrays.toString(merge(nums1, nums2)));
    }

    private static int[] mergedSorted(int[]nums1, int m, int[] nums2, int n){
        for(int i = m, j= 0; i < nums1.length; i++,j++)
            nums1[i] = nums2[j];

        Arrays.sort(nums1);
        return nums1;
        
    }
    static int[] merge(int[] foo, int[] bar) {
        //int m = nums1.length, n = nums2.length;
        /*int first = nums1.length - 1, second = nums2.length - 1;
        int i = first + second - 1;
        System.out.println(i);
        while (first >=0 && second >= 0) {
            nums1[i--] = (nums1[first] > nums2[second]) ? nums1[first--] : nums2[second--];
        }
        return nums1;*/
        /*int arr1Len = nums1.length, arr2Len = nums2.length;
        int[] merged = new int[arr1Len + arr2Len];
        int arr1Position = 0, arr2Position = 0, mergedPosition = 0;
        
        while (arr1Position < arr1Len && arr2Position < arr2Len) {
            if (nums1[arr1Position] < nums2[arr2Position])
                merged[mergedPosition++] = nums1[arr1Position];
            else
                merged[mergedPosition++] = nums2[arr2Position];
        }
        
        while (arr1Position < arr1Len)
            merged[mergedPosition++] = nums1[arr1Position];
        
        while (arr2Position < arr2Len)
            merged[mergedPosition++] = nums2[arr2Position];
        
        return merged;*/
        int fooLength = foo.length;
        int barLength = bar.length;
    
        int[] merged = new int[fooLength + barLength];
    
        int fooPosition, barPosition, mergedPosition;
        fooPosition = barPosition = mergedPosition = 0;
    
        while(fooPosition < fooLength && barPosition < barLength) {
            if (foo[fooPosition] < bar[barPosition]) {
                merged[mergedPosition++] = foo[fooPosition++];
            } else {
                merged[mergedPosition++] = bar[barPosition++];
            }
        }
    
        while (fooPosition < fooLength) {
            merged[mergedPosition++] = foo[fooPosition++];
        }
    
        while (barPosition < barLength) {
            merged[mergedPosition++] = bar[barPosition++];
        }
    
        return merged;
    }
    
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                    nums1[tail1--] : nums2[tail2--];
        }
        
        while (tail2 >= 0) { //only need to combine with remaining nums2
            nums1[finished--] = nums2[tail2--];
        }
        
        System.gc();
    }
}
