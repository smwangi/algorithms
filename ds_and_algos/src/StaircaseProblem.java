import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * StaircaseProblem
 */
public class StaircaseProblem {

    public static void main(String[] args) {
        int n= 4;
        int[] arr = {1,3,5};
      // int[] res= get_ways(n, arr);
       //System.out.println(res.length);
       System.out.println(get_ways(n, arr));
    }

    static int get_ways(int n, int[] arr){
        int[] nums = new int[n+1];
        
        //str.forEach(x -> System.out.println(x));
        //nums[0] = 1;
       
        for(int i = 1; i< nums.length;i++){
            int total = 0;
            //for(int j=0; j<arr.length;j++){
            for(int j : arr){
               
                if(i - j >= 0){
                    System.out.print("i-j ");System.out.println(nums[i-j]);
                    total += i-j;
                }
                
            }
            nums[i] = total;
        }
        IntStream str = Arrays.stream(nums);
        return str.sum();
    }
}