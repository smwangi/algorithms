import java.util.*;
/**
 * NextPermutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * Analysis
 *   The steps to solve this problem:
 *   1) scan from right to left, find the first element that is less than its previous one.

 *  4 5 6 3 2 1 
    |
    p
    
    2) scan from right to left, find the first element that is greater than p.

    4 5 6 3 2 1 
        |
        q
    
        3) swap p and q

    4 5 6 3 2 1 
    swap
    4 6 5 3 2 1 
    
    4) reverse elements [p+1, nums.length]

    4 6 1 2 3 5 
 */
public class NextPermutation {

    public static void main(String[] args) {
        
        int[]arr = {2, 3,  1};
        nextPermitation(arr);
    }

    static void nextPermitation(int[] arr){
        //find decreasing digit
        int mark = -1;
        for(int i = arr.length-1; i> 0;i--){
            //System.out.print(arr[i]+" "+arr[i-1]+" ");
            if(arr[i] > arr[i-1]){
                mark = i-1;
                break;
            }
            
        }
        
        if(mark == -1){
            reverse(arr, 0, arr.length-1);
            return;
        }

        int index = arr.length-1;
        for(int i= arr.length-1; i >= mark+1;i--){
            if(arr[i] > arr[mark]){
                index = i;
                break;
            }
        }
        swap(arr, mark, index);
        //System.out.println(mark+1+" "+index);
        reverse(arr, mark+1, arr.length-1);
        System.out.print(Arrays.toString(arr));
        

    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(int[] arr,int i, int j){
        while(i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    static void reverse1(int[] arr){
        int[] temp = new int[arr.length];
    }
}