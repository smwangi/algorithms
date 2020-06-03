package codes;

import java.util.HashSet;

public class ShortestDistanceBtnNumbersInArray {

    public int findTheDistanceValue(int[] arr1, int[] arr2,int d){
        int distance = 0;
        int currentArr1Num = 0;
        boolean  flag = true; //To check arr[i] validity. initially considered ok
        HashSet<Integer> set = new HashSet<>();
        for (int i =0; i< arr1.length; i++){
            currentArr1Num = arr1[i];
            for (int j = 0; j < arr2.length;j++){
                //System.out.println(Math.abs(arr1[i] - arr2[j]));
                System.out.format("%d - %d = %d",arr1[i],arr2[j],Math.abs(arr1[i] - arr2[j]));
                System.out.println();
                if( Math.abs(arr1[i] - arr2[j]) <= d && set.contains(currentArr1Num))
                    set.remove(currentArr1Num);
                else
                if(currentArr1Num >= d)
                    set.add(currentArr1Num);

            }
        }
        set.forEach(t->System.out.println(t));
        return set.size();
    }
}
