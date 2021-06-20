import java.util.HashMap;

/**
 * Check for Majority Element in a sorted array
 * Question: Write a C function to find if a given integer x appears more than n/2 times in a sorted array of n integers.
 *
 * Basically, we need to write a function say isMajority() that takes an array (arr[] ),
 * array’s size (n) and a number to be searched (x) as parameters and returns true if x is a majority element (present more than n/2 times).
 *
 * Examples:
 *
 * Input: arr[] = {1, 2, 3, 3, 3, 3, 10}, x = 3
 * Output: True (x appears more than n/2 times in the given array)
 *
 * Input: arr[] = {1, 1, 2, 4, 4, 4, 6, 6}, x = 4
 * Output: False (x doesn't appear more than n/2 times in the given array)
 *
 * Input: arr[] = {1, 1, 1, 2, 2}, x = 1
 * Output: True (x appears more than n/2 times in the given array)
 *
 * METHOD 1 (Using Linear Search)
 * Linearly search for the first occurrence of the element, once you find it (let at index i), check element at index i + n/2.
 * If element is present at i+n/2 then return 1 else return 0.
 */
public class MajorityElement {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 4, 4, 4};
        int n = arr.length;
        int x = 4;
        if (isMajority(arr, n, x) == true)
            System.out.println(x+" appears more than "+
                    n/2+" times in arr[]");
        else
            System.out.println(x+" does not appear more than "+
                    n/2+" times in arr[]");
        System.out.println(majorityElement(arr));
    }
    static boolean isMajority(int[] arr, int n, int x) {
        int i, last_index = 0;
        // get the last index according to n (even or odd)
        last_index = (n % 2 == 0) ? n / 2 : n / 2 + 1;
        // search for first occurrence of x in arr[]
        for (i = 0; i < last_index; i++) {
            // Check if x is present and is present more than n/2 times
            if (arr[i] == x && arr[i+n/2] == x)
                return true;
        }
        return false;
    }
    // Using Binary Search
     /* If x is present in arr[low...high] then returns the index of
        first occurrence of x, otherwise returns -1 */
    static int  _binarySearch(int arr[], int low, int high, int x)
    {
        if (high >= low)
        {
            int mid = (low + high)/2;  /*low + (high - low)/2;*/
  
            /* Check if arr[mid] is the first occurrence of x.
                arr[mid] is first occurrence if x is one of the following
                is true:
                (i)  mid == 0 and arr[mid] == x
                (ii) arr[mid-1] < x and arr[mid] == x
            */
            if ( (mid == 0 || x > arr[mid-1]) && (arr[mid] == x) )
                return mid;
            else if (x > arr[mid])
                return _binarySearch(arr, (mid + 1), high, x);
            else
                return _binarySearch(arr, low, (mid -1), x);
        }
    
        return -1;
    }
    
    
    /* This function returns true if the x is present more than n/2
        times in arr[] of size n */
    static boolean isMajorityBS(int arr[], int n, int x)
    {
        /* Find the index of first occurrence of x in arr[] */
        int i = _binarySearch(arr, 0, n-1, x);
        
        /* If element is not present at all, return false*/
        if (i == -1)
            return false;
        
        /* check if the element is present more than n/2 times */
        if (((i + n/2) <= (n -1)) && arr[i + n/2] == x)
            return true;
        else
            return false;
    }
    
    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than
     * floor(n/2) times.
     *
     * You may assume that the array is non-empty and the majority element always exist in the array.
     *
     * Example :
     *
     * Input : [2, 1, 2]
     * Return  : 2 which occurs 2 times which is greater than 3/2.
     */
    static int majorityElement(int[] a) {
        int majority = (int) Math.floor(a.length / 2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int element = a[i];
            if (map.containsKey(element))
                map.put(element, map.get(element) + 1);
            else
                map.put(element, 1);
            if (map.get(element) > majority)
                return element;
        }
        return -1;
    }
}
