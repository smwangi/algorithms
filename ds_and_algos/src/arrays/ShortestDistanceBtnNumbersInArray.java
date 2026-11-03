package arrays;


import java.util.HashSet;

public class ShortestDistanceBtnNumbersInArray {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int currentArr1Num = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int k : arr1) {
            currentArr1Num = k;
            for (int i : arr2) {
                //System.out.println(Math.abs(arr1[i] - arr2[j]));
                System.out.format("%d - %d = %d", k, i, Math.abs(k - i));
                System.out.println();
                if (Math.abs(k - i) <= d && set.contains(currentArr1Num))
                    set.remove(currentArr1Num);
                else if (currentArr1Num >= d)
                    set.add(currentArr1Num);

            }
        }
        set.forEach(System.out::println);
        return set.size();
    }
}
