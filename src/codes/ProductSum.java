import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that takes in a "special array" and returns its product sum.
 * A "special" array is a non-empty array that contains either integers or other "special" arrays.
 * The product sum of a "special" array is the sum of its elements, where "special" arrays inside
 * it are summed themselves and then multiplied by their level of depth.
 *
 * The depth of a "special" array is how far nested it is. For instance, the depth of [] is 1; the depth
 * of the inner array in [[]] is 2; the depth of the innermost array in [[[]]] is 3.
 *
 * Therefore, the product sum of [x,y] is x+y; the product sum of [x, [y + z]] is x + 2 * (y + z); the product sum
 * of [x, [y, [z]]] is x + 2 * (y + 3z).
 *
 * Sample input
 * array = [5, 2, [7, -1], 3, [6, [-13, 8], 4]
 *
 * sample output:
 * 12
 *
 * Hints:
 * 1. Use recursion to solve this problem.
 * 2. Initialize the product sum of the "special" array to 0. Then, iterate through all the array's elements;
 *      if you come across a number, add it to the product sum; if you come across another "special" array, recursively call
 *      the productSum function on it and add the returned value to the product sum. How will you handle multiplying the
 *      product sums at a given level of depth?
 * 3. Have the productSum function take in a second parameter; the multiplier, initialized to 1. Whenever you
 *      recursively call the productSum function, pass in the multiplier incremented by 1.
 *
 *  Optimal Space and Time Complexity
 *  O(n) time | O(d) space - where n is the total number of elements in the array, including sub-elements, and d is the
 *  greatest depth of "special" arrays in the array.
 */
public class ProductSum {
    public static void main(String[] args) {
        List<Object> array = new ArrayList<>();
        array.add(5);
        array.add(2);
        array.add(new int[]{7, -1});
    }
    // You can use `element instanceof ArrayList` to check whether an item
    // is an array or an integer
    static int productSum(List<Object> array) {
        return productSumHelper(array, 1);
    }
    
    static int productSumHelper(List<Object> array, int multiplier) {
        int sum = 0;
        for (Object elem : array) {
            if (elem instanceof ArrayList) {
                ArrayList<Object> arr = (ArrayList<Object>) elem;
                sum += productSumHelper(array, multiplier + 1);
            } else {
                sum += (int) elem;
            }
        }
        return sum * multiplier;
    }
}
