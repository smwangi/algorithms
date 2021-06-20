
import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, and k. Write a program to find indexes of two elements in an array which sum is equal to K.
 */
public class TwoSumProblem {
    public static void main(String[] args) {

        int[] arr = {5, 4, 7, 3, 9, 2};
        int k = 13;
        System.out.println(Arrays.toString(twoSumProblem(arr,k)));
    }
    /**
     * Solution: Use Map
     *
     *     Construct a map that stores the array element as key and its index as value.
     *     Iterate the array and for every element x-
     *         Calculate  y = K-x.
     *         Check if y is present in the map,
     *             If yes then we have found the pair which sum to K. Get the index of y from the map and print it along with the index of x.
     *             If not then add x and its index into the map.
     *
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    private static int[] twoSumProblem(int[]arr, int k){
        int[] res = new int[2];
        HashMap<Integer,Integer> elements = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            int num1 = arr[i];
            int num2 = k - num1;
            if(elements.containsKey(num2)){
                res[0] = i;
                res[1] = elements.get(num2);
                break;
            }
            elements.put(num1,i);
        }

        return res;
    }
}
