import java.util.Arrays;
import java.util.Comparator;

/**
 * Suppose we have a list of N numbers,
 * and repeat the following operation until we're left with only a single number:
 * Choose any two numbers and replace them with their sum.
 *
 * Moreover, we associate a penalty with each operation equal to the value of the new number,
 * and call the penalty for the entire list as the sum of the penalties of each operation.
 *
 * For example, given the list [1, 2, 3, 4, 5],
 * we could choose 2 and 3 for the first operation,
 * which would transform the list into [1, 5, 4, 5] and incur a penalty of 5.
 *
 * The goal in this problem is to find the worst possible penalty for a given input.
 *
 * Input:
 *
 * An array arr containing N integers, denoting the numbers in the list.
 *
 * Output format:
 *
 * An int representing the worst possible total penalty.
 *
 * Constraints:
 *
 * o 1 ≤ N ≤ 10^6
 * o 1 ≤ Ai ≤ 10^7, where *Ai denotes the ith initial element of an array.
 * o The sum of values of N over all test cases will not exceed 5 * 10^6.
 *
 * The idea is to sum the numbers in the array two at a time replacing them by their sum.
 * The sum is known as a penalty. Each time you get a penalty you add it to a total.
 * The idea is to get the highest possible penalty.
 *
 * Sample:
 * 1,2,3,4,5
 * main <<< arr: [1, 2, 3, 4, 5]
 * main <<< output: 50
 *
 *
 * 4,2,1,3
 * main <<< arr: [4, 2, 1, 3]
 * main <<< output: 26
 */
public class SlowSum {
    
    public static void main(String[] args) {
        int[] arr = {2, 3, 9, 8, 4};//{4, 2, 1, 3};
        System.out.println(getTotalTime(arr));
    }
    
    /**
     * Solution:
     * We need to sort the elements in the array in descending order.
     * The array is of type int[] so we are not able to sort the array in descending order with a comparator because it expects an object,
     * in this case it would be Integer but we have an array of int.
     *
     * We can create a stream, box the contents so they are upgraded to Integer,
     * sort using a comparator, may the Integer to int and then collect the results in an array of int.
     *
     * We then initialize our first penalty and also add it to the running total for penalties.
     *
     * Now we are ready to loop through the rest of the array entries. We compute the penalty and then add it to the penalties.
     * @param arr
     * @return
     */
    static int getTotalTime(int[] arr) {
        //Sort the array in descending order
        int[] sorted = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        int penalty = sorted[0] + sorted[1];
        int penalties = penalty;
        for (int i = 2; i < arr.length; i++) {
            penalty += arr[i];
            penalties += penalty;
        }
        return penalties;
    }
}
