package codes;

import java.util.HashSet;

/**
 * Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
 *
 * The distance value is defined as the number of elements arr1[i] such that there is not any element
 * arr2[j] where |arr1[i]-arr2[j]| <= d.
 */
public class DistanceBtnArrays {

    public int findTheDistanceValue(int[] arr1, int[] arr2,int d){
        int distance = 0;

        for (int i =0; i< arr1.length; i++){

            for (int j = 0; j < arr2.length;j++){
                //System.out.println(Math.abs(arr1[i] - arr2[j]));
                //System.out.format("%d - %d = %d",arr1[i],arr2[j],Math.abs(arr1[i] - arr2[j]));
                //System.out.println();
                if( Math.abs(arr1[i] - arr2[j]) <= d )
                    break;
                else{
                    System.out.format("%d - %d",j,arr2.length-1);
                    System.out.println();
                    if(j == arr2.length-1){
                        distance++;
                    }

                }

            }
        }

        return distance;
    }
}
