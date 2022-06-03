import java.util.Arrays;

public class MergeArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        merge(arr1, arr2, 3, 3);
    }
    
    private static void merge(int[] arr1, int[] arr2, int m, int n) {
        // arr1 = [1,2,3,0,0,0]
        // arr2 = [2,5,6]
        int arr1Count = m - 1, arr2Count = n - 1, finalArrCount = m + n -1;
        while (arr1Count >= 0 && arr2Count >= 0) {
            arr1[finalArrCount--] = (arr1[arr1Count] > arr2[arr2Count]) ? arr1[arr1Count--] : arr2[arr2Count--];
        }
        
        while (arr2Count >= 0) { // only need to combine with remaining num2
            arr1[finalArrCount--] = arr2[arr2Count--];
        }
        
        System.out.println(Arrays.toString(arr1));
    }
    
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int ni = nums1.length - 1;
        while(i >= 0 || j >= 0){
            if(i < 0){
                nums1[ni] = nums2[j];
                j--;
            } else if(j < 0){
                nums1[ni] = nums1[i];
                i--;
            } else if(nums1[i] < nums2[j]){
                nums1[ni] = nums2[j];
                j--;
            } else {
                nums1[ni] = nums1[i];
                i--;
            }
            ni--;
        }
    }
}
