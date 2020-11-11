import java.util.Arrays;

/**
 * Given an array K with N integers from 1 to N+1 such that the array has exactly one integer missing, write
 * a Java function that returns the missing integer.
 * e.g. given K = [3,5,4,1], the function should return 2
 */
public class MissingNumber {
    public static void main(String[] args) {

        int[] arr = {7,5,1,3,2,6};// {3,5,4,1};
        System.out.println(missingNum(arr));
    }

    /**
     * Sort the array of numbers.
     * check if current value + 1 (arr[i]+1 = arr[i+1] (value in the next index))
     * if not return value in current index + 1
     * @param arr
     * @return
     */
    static int missingNum(int[] arr){
        if(arr.length == 0) return 0;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length;i++){
            if(arr[i]+1 == arr[i+1])
                continue;
            else return arr[i]+1;
        }
        return 0;
    }
}
