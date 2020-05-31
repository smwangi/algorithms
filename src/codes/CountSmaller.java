package codes;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller {

    public static void main(String[] args) {
        int[] arr = {5,2,6,1};
        countSmaller(arr);
    }

    static List<Integer> countSmaller(int[] nums){
        List<Integer> smalls = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int small = 0;
            for (int j=i+1; j < nums.length; j++){
                if(nums[j] < nums[i]  )
                    ++small;
                //System.out.println(nums[j]);
            }
            smalls.add(small);
        }
        smalls.stream().forEachOrdered(System.out::println);
        return smalls;
    }
}
