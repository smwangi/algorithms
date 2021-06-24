import java.util.HashSet;
import java.util.Set;

/**
 * Given an array a that contains only numbers in the range from 1 to a.length,
 * find the first duplicate number for which the second occurrence has the minimal index.
 * In other words, if there are more than 1 duplicated numbers,
 * return the number for which the second occurrence has a smaller index than the second occurrence of the other number does.
 * If there are no such elements, return -1.
 *
 * Example
 *
 * For a = [2, 1, 3, 5, 3, 2], the output should be firstDuplicate(a) = 3.
 *
 * There are 2 duplicates: numbers 2 and 3. The second occurrence of 3 has a smaller index than the second occurrence of 2 does,
 * so the answer is 3.
 *
 * For a = [2, 2], the output should be firstDuplicate(a) = 2;
 *
 * For a = [2, 4, 3, 5, 1], the output should be firstDuplicate(a) = -1.
 *
 * Input/Output
 *
 * [execution time limit] 3 seconds (java)
 *
 * [input] array.integer a
 *
 * Guaranteed constraints:
 * 1 ≤ a.length ≤ 105,
 * 1 ≤ a[i] ≤ a.length.
 *
 * [output] integer
 *
 * The element in a that occurs in the array more than once and has the minimal index for its second occurrence.
 * If there are no such elements, return -1.
 */
public class FirstInDuplicate {
    public static void main(String[] args) {
        int[] a = {2, 1, 3, 5, 3, 2};
        System.out.println(firstDuplicate(a));
        System.out.println(firstDuplicate2(a));
        test();
    }
    static int firstDuplicate(int[] a) {
        int dup = -1;
        Set<Integer> set = new HashSet<>();
        for (int i=0; i< a.length; i++) {
            if(set.contains(a[i])){
             dup = a[i];
             break;
            }
            set.add(a[i]);
        }
        return dup;
    }

    static int firstDuplicate2(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if(a[Math.abs(a[i]) - 1] < 0) {
                return Math.abs(a[i]);
            } else {
                System.out.print(Math.abs(a[i]) -1+" ");
                a[Math.abs(a[i]) - 1] = -a[Math.abs(a[i]) - 1];
            }
        }
        return -1;
    }
    
    static void test() {
        Integer a, b, p, sum, N = 5;
        p = -5;
        a = 0;
        b = N;
        sum = 0;
        while (a < N && b > 0) {
            if (p > 0) {
                a = a + 1;
                sum = sum + 1;
            } else {
                a = a -1;
                b = b - 1;
                sum = sum + 1;
            }
        }
        modify(p);
        System.out.println("Sum "+sum+" a "+a+" b "+b);
    }
    static void modify(Integer p) {
       p--;
    }
}
