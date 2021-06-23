
import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {

        int arr[] = { 2, 3, 4, 10, 40 };
        int l  = 0;
        int r = arr.length-1;
        int x = 3;
        int result = binarySrchRecursive(arr,l,r,x);
        int result2 = binarySrchWhile(arr,x);
        int result3 = binarySearch(arr,x);
        if(result2 == -1)
            System.out.println("Element not found: ");
        else
            System.out.println("Element found at index: "+result2);

        //System.out.println(Arrays.binarySearch(arr,x));
    }

    static int binarySrchRecursive(int[] arr, int l, int r, int x){
        if(r > l){
            int mid = l+(r - l)/2;

            //If the element X is present at middle
            if(arr[mid] == x)
                return mid;

            //If element is smaller than mid, then it can be present at left subarray
            if(arr[mid] > x)
                return binarySrchRecursive(arr,l,mid -1,x);

            return binarySrchRecursive(arr,mid +1,r,x);
        }

        return  -1;
    }

    static int binarySrchWhile(int[] arr, int x){

        int l = 0, r = arr.length-1;
        while (l <= r){

            int mid = l+(r - l)/2;
            System.out.println("mid index "+mid+" mid value "+arr[mid]+" target "+x);
            //Check of x is present at mid
            if(arr[mid] == x)
                return mid;

            if(x > arr[mid] ){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return -1;
    }
    // Best
    static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }
    static int binarySearch(int[] array, int target, int l, int r) {
        if (l > r)
            return -1;
        int mid = (l + r) / 2;
        int potentialMatch = array[mid];
        if (target == potentialMatch)
            return mid;
        else if (target < potentialMatch) {
            return binarySearch(array, target, l, mid - 1);
        } else
            return binarySearch(array, target, mid + 1, r);
    }
}