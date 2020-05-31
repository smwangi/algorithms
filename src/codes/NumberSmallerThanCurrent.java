package codes;

import java.util.ArrayList;
import java.util.List;

public class NumberSmallerThanCurrent {

    public static void main(String[] args) {

        int[] arr = {8,1,2,2,3};
        numSmallerThanCurrent(arr);
    }

    static int[] numSmallerThanCurrent(int[] n){
        List<Integer> nums = new ArrayList<>();

        for(int i=0;i< n.length;i++){

            int nTimes = 0;
            for (int j=0;j<n.length;j++){
                if(n[i] != n[j] && n[j] < n[i])
                    ++nTimes;
            }
            nums.add(nTimes);
        }
        nums.stream().forEachOrdered(System.out::print);
        return nums.stream().mapToInt(i ->i).toArray();
    }
}
