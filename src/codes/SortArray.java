package codes;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] A = {-1,0,3,10,-4};
        int[] B = {4,3,2,-6,1};
        sortArr(B);
    }

    private static int[] sortArr(int[] arr){
        //int[] sortedArr = new int[arr.length];
        for (int i = 0;i < arr.length;i++){
            for(int j = i+1;j<arr.length;j++){

                if(arr[i]< arr[j])
                    continue;
                else{
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
