import java.util.*;

/**
 * Given an array of integers 1 <= a[i] <= n (n=size of array), some elements appear twice and others appear once
 *
 * Find all the elements that appear twice in this array
 *
 * Could you do it without extra space and O(n) runtime?
 *
 * Example
 * input
 * [4,3,2,7,8,2,3,1]
 *
 * output: [2,3]
 */
public class FindAllDupsInArray {

    public static void main(String[] args) {
        FindAllDupsInArray dupsInArray  = new FindAllDupsInArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        dupsInArray.findDuplicates(nums);
        PriorityQueue<Integer> queue = new PriorityQueue<>( Collections.reverseOrder());
        queue.addAll(Arrays.asList(4,3,2,7,8,2,3,1));
        for (int i=0;i<queue.size();++i)
            System.out.print(queue.poll()+" ");
    }

    public List<Integer> findDuplicates(int[] nums){
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i])-1;

            if(nums[idx] < 0) result.add(Math.abs(nums[i]));

            nums[idx] *=-1;
        }
        result.forEach(System.out::println);
        return result;
    }
}
