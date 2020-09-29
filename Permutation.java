import java.util.*;
/**
 * Permutation
 */
public class Permutation<T> {

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4};
        permutation(4,arr);
    }
    //Recursive
    static <T> void permutation(int n,T[]arr){

        if(n ==1){
            System.out.println(Arrays.toString(arr));
        }else{
            for(int i=0; i < n- 1;i++){
                permutation(n-1, arr);
                if(n%2==0){
                    swap(arr, i, n-1);
                }else{
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
}