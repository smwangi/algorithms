/**
 * Find the minimum element in a sorted and rotated array
 *
 * A sorted array is rotated at some unknown point, find the minimum element in it.
 * The following solution assumes that all elements are distinct.
 *
 * Examples:
 *
 * Input: {5, 6, 1, 2, 3, 4}
 * Output: 1
 *
 * Input: {1, 2, 3, 4}
 * Output: 1
 *
 * Input: {2, 1}
 * Output: 1
 *
 * A simple solution is to traverse the complete array and find a minimum. This solution requires O(n) time.
 * We can do it in O(Logn) using Binary Search. If we take a closer look at the above examples,
 * we can easily figure out the following pattern:
 *
 * The minimum element is the only element whose previous is greater than it. If there is no previous element,
 * then there is no rotation (the first element is minimum). We check this condition for the middle element
 * by comparing it with (mid-1)’th and (mid+1)’th elements.
 * If the minimum element is not at the middle (neither mid nor mid + 1), then the minimum element lies in either the
 * left half or right half.
 * If the middle element is smaller than the last element, then the minimum element lies in the left half
 * Else minimum element lies in the right half.
 */
public class MinElemInRotatedArr {
    public static void main(String[] args) {
        int arr1[] =  {5, 6, 1, 2, 3, 4};
        int n1 = arr1.length;
        System.out.println("The minimum element is "+ findMin(arr1, 0, n1-1));
    
        int arr2[] =  {1, 2, 3, 4};
        int n2 = arr2.length;
        System.out.println("The minimum element is "+ findMin(arr2, 0, n2-1));
    
        int arr3[] =  {1};
        int n3 = arr3.length;
        System.out.println("The minimum element is "+ findMin(arr3, 0, n3-1));
    
        int arr4[] =  {1, 2};
        int n4 = arr4.length;
        System.out.println("The minimum element is "+ findMin(arr4, 0, n4-1));
    
        int arr5[] =  {2, 1};
        int n5 = arr5.length;
        System.out.println("The minimum element is "+ findMin(arr5, 0, n5-1));
    
        int arr6[] =  {5, 6, 7, 1, 2, 3, 4};
        int n6 = arr6.length;
        System.out.println("The minimum element is "+ findMin(arr6, 0, n6-1));
    
        int arr7[] =  {1, 2, 3, 4, 5, 6, 7};
        int n7 = arr7.length;
        System.out.println("The minimum element is "+ findMin(arr7, 0, n7-1));
    
        int arr8[] =  {2, 3, 4, 5, 6, 7, 8, 1};
        int n8 = arr8.length;
        System.out.println("The minimum element is "+ findMin(arr8, 0, n8-1));
    
        int arr9[] =  {3, 4, 5, 1, 2};
        int n9 = arr9.length;
        System.out.println("The minimum element is "+ findMin(arr9, 0, n9-1));
    }
    static int findMin(int[] arr, int low, int high) {
        // This condition is needed to handle the case when array
        // is not rotated at all
        if (high < low)
            return arr[low];
        // if there is only one element left
        if (high == low)
            return arr[low];
        // find mid
        int mid = low + (high - low) / 2;
        // Check if element (mid + 1) is minimum element Consider cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid+1] < arr[mid])
            return arr[mid + 1];
        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];
        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
            return findMin(arr, low, mid - 1);
        return findMin(arr, mid + 1, high);
    }
    /**
     * How to handle duplicates?
     *
     * The above approach in the worst case(If all the elements are the same) takes O(N).
     * Below is the code to handle duplicates in O(log n) time.
     */
    static int findMin2(int[] arr, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == arr[high])
                high--;
            else if (arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
        return arr[high];
    }
}
