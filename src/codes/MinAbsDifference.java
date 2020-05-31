package codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 *
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 *
 *     a, b are from arr
 *     a < b
 *     b - a equals to the minimum absolute difference of any two elements in arr
 *
 * Example 1:
 *
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 *
 * Example 2:
 *
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 *
 * Example 3:
 *
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 *
 * Constraints:
 *
 *     2 <= arr.length <= 10^5
 *     -10^6 <= arr[i] <= 10^6
 */
public class MinAbsDifference {

    public static void main(String[] args) {

        int[] arr = {1,3,6,10,15};
        minAbsDiff(arr).forEach(x -> {
            x.forEach(p->System.out.println(p));
        });
    }

    static List<List<Integer>> minAbsDiff(int[]arr){

        List<List<Integer>> result = new ArrayList<>();

        int min = Integer.MAX_VALUE;

        Arrays.sort(arr);
        //for (int i = 0; i < arr.length; i++){

            for(int j = 1;j< arr.length; j ++){
                int difference = Math.abs(arr[j] - arr[j-1]);
                System.out.println("Diff "+difference+" min "+min);
                if(difference < min){
                    min = difference;
                    System.out.println("Diff2 "+difference+" min2 "+min);
                    result.clear();

                    //System.out.println(arr[j]+" - "+arr[j-1]+" = "+difference);
                    result.add(Arrays.asList(arr[j-1],arr[j]));
                }else if(difference == min){
                    result.add(Arrays.asList(arr[j-1],arr[j]));
                }


            }
            System.out.println("MIN "+min);
        //}

        return result;
    }
}
