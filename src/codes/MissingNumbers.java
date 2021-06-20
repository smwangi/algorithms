
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumbers {

    public static void main(String[] args) {

        int[] arr  = {11, 4, 11, 7, 13, 4, 12, 11, 10, 14};
        int[] brr = {11, 4, 11, 7, 3, 7, 10, 13, 4, 8, 12, 11, 10, 14, 12};

        System.out.println(Arrays.toString(missingNumbers(arr,brr)));
    }

    static int[] missingNumbers(int[] arr, int[] arr2){

        Arrays.sort(arr);
        Arrays.sort(arr2);

        int[] a = new int[arr2.length];

        int startIdx = 0;
        for(int i = 0; i < arr.length; i++) {

         INNER:   for(int j = startIdx; j < arr2.length; j++) {
            System.out.println(arr[i]+" <> "+arr2[j]+" <> "+startIdx+" <> "+j);
             startIdx++;
                if(arr2[j] == arr[i]){
                    a[j] =     arr2[j] - arr[i];

                    break INNER;
                }else{
                    a[j] = arr2[j];
                }

         }
        }
        return Arrays.stream(a).filter(x -> x > 0).distinct().toArray();
    }
}
