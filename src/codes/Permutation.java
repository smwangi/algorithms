
import java.util.*;
/**
 * Permutation
 */
public class Permutation<T> {

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,};
        permutation(3,arr);
        int[] a = new int[]{1,2,3};
        List<Integer> arrList = new ArrayList<>(Arrays.asList(1, 2, 3));
        
        Permutation<Integer> permutation = new Permutation<>();
        permutation.subsets(a).forEach(x -> System.out.print(x+" "));
        System.out.println();
        permutation.permute(a).forEach(x -> System.out.print(x+" "));
        System.out.println();
        permutation.permute2(a).forEach(x -> System.out.print(x+" "));
        System.out.println();
        getPermutations(arrList).forEach(x -> System.out.println(x + " <> "));
    }
    //Recursive
    static <T> void permutation(int n, T[]arr) {

        if (n ==1) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i=0; i < n- 1;i++) {
                permutation(n-1, arr);
                if (n%2  == 0) {
                    swap(arr, i, n-1);
                } else {
                    swap(arr, 0, n-1);
                }
            }
            permutation(n-1, arr);
        }

    }
    static <T> void swap(T[]arr,int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static void permuteIteratively(int n, int[] arr) {
    
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer>tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
    
    /**
     * The backtracking template remains unchanged, but according to the trees drawn by the permutation problem and the combination problem, the tree of the permutation problem is relatively symmetrical, and the tree of the combination problem has fewer right nodes.
     * In the code we can see, the permutation problem uses the contains method to exclude the numbers that have been selected in track each time; while the combination problem passes a start parameter to exclude the numbers before the start index .
     * The above is the solution to the three problems of permutation, combination and subsets. To sum up:
     * The subset problem can use the idea of mathematical induction: assuming that the results of a smaller problem are known, and thinking about how to derive the results of the original problem. You can also use the backtracking algorithm, using the start parameter to exclude selected numbers.
     * The combination problem uses the backtracking idea, and the results can be expressed as a tree structure. We only need to apply the backtracking algorithm template. The key point is to use a start to exclude the selected numbers.
     * The permutation problem uses the backtracking idea, and it can also be expressed as a tree structure to apply the algorithm template. The key point is to use the contains method to exclude the selected numbers. There is detailed analysis previously. Here we mainly compare it with the combination problem.
     * Keeping the shape of these trees in mind is enough to deal with most backtracking algorithm problems. It is nothing more than the pruning of start or contains. There is no other trick.
     */
    List<List<Integer>> res = new LinkedList<>();
    List<List<Integer>> permute(int[] nums) {
        // record "path"
        LinkedList<Integer> track = new LinkedList<>();
        backtrack2(nums, track);
        return res;
    }
    void backtrack2(int[] nums, LinkedList<Integer>track) {
        // trigger the ending condition
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // exclude illegal selection
            if (track.contains(nums[i]))
                continue;
            // select
            track.add(nums[i]);
            // go to the next decision tree
            backtrack2(nums, track);
            // deselect
            track.removeLast();
        }
    }
    
    /**
     * Algorithm
     * Create a List to store each permutations of the given array.
     * Start with the first index of the array.
     * Traverse till the last element of the array, at each position do two things Swap the current index with the start index.
     * Then Recursively traverse to the next index of the array.
     * In order for these operations to not end in an infinite loop. Swap back the current index and the start index for the next iteration.
     * Whenever the recursion reaches the end of the array, add the particular order to the result list.
     * Return the list at the end of the recursion
     */
    List<List<Integer>> result;
    int[]nums;
    public List<List<Integer>> permute2(int[] nums) {
        result = new ArrayList<>();
        this.nums = nums;
        permutations(0);
        return result;
    }
    private void permutations(int start) {
        if (start == nums.length) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i < nums.length; i++)
                row.add(nums[i]);
            result.add(row);
        } else {
            for (int i = start; i < nums.length; i++) {
                swap2(i, start);
                permutations(start + 1);
                swap2(i, start);
            }
        }
    }
    void swap2(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        permute(array, new ArrayList<Integer>(), result);
        return result;
    }
    
    private static void permute(List<Integer> array, List<Integer> currentPermutations, List<List<Integer>> permutations) {
        if (array.size() == 0 && currentPermutations.size() > 0) {
            permutations.add(currentPermutations);
        } else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> newArr = new ArrayList<>(array);
                newArr.remove(i);
                List<Integer> newPermutation = new ArrayList<>(currentPermutations);
                newPermutation.add(array.get(i));
                permute(newArr, newPermutation, permutations);
            }
        }
    }
}