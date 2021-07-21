
import java.util.Arrays;

/**
 * Through our app, a customer can filter out items which have a price below n dollars, select a bottle from the search results,
 * and add them to his cart. We have millions of users seeking wines with a price limit every second. The results need to be fast.
 *
 * On the backend, our algorithm runs a linear search through the entire list of wines comparing the price limit entered by
 * the customer with the price of every wine bottle in the list.
 *
 * Then, it returns items which have a price less than or equal to the price limit. This linear search has a time complexity of O(n).
 *
 * This means the bigger the number of wine bottles in our system, the more time it will take. The search time increases
 * proportionately to the number of new items introduced.
 *
 * If we start saving items in sorted order and search for items using the binary search, we can achieve a complexity of O(log n).
 *
 * With binary search, the time taken by the search results naturally increases with the size of the dataset, but not proportionately.
 *
 * Simply put, the algorithm compares the key value with the middle element of the array; if they are unequal,
 * the half in which the key cannot be part of is eliminated, and the search continues for the remaining half until it succeeds.
 *
 * Remember – the key aspect here is that the array is already sorted.
 *
 * If the search ends with the remaining half being empty, the key is not in the array.
 */
public class BinarySearch2 {

    public static void main(String[] args) {

        int arr[] = { 2, 3, 4, 10, 40 };
        int l  = 0;
        int r = arr.length-1;
        int x = 10;

        Arrays.sort(arr);
        runBinarySearchIteratively(arr,x,l,r);
        System.out.println(runBinarySearchRecursively(arr,x,l,r));
    }

    //Iterative Implementation
    public static int runBinarySearchIteratively(int[] arrSorted,int key, int low, int high){
        int index = Integer.MAX_VALUE;

        while (low < high){
            int mid = (low+high)/2;
            //System.out.println(mid);
            if(key < arrSorted[mid] ){
                high = mid;
            }else if(key > arrSorted[mid]){
                low = mid;
            }else if(arrSorted[mid] == key){
                index = mid;
                break;
            }
        }
        System.out.println(index);
        return index;
    }

    public static int runBinarySearchRecursively(int[] arrSorted,int key, int l, int r){
        int mid = (l+r)/2;
        if (r < l) {
            return -1;
        }

        if (key == arrSorted[mid]) {
            return mid;
        } else if (key < arrSorted[mid]) {
            return runBinarySearchRecursively(arrSorted, key, l,mid-1);
        } else {
            return runBinarySearchRecursively(arrSorted, key,mid+1, r);
        }
    }
}
