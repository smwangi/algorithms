/**
 * LCM
 * LCM of 2 integers is the smallest positive integer that is perfectly divisible by both numbers without a remainder.
 * LCM cannot be less than the largest number
 */
public class LCM {

    public static void main(String[] args) {
        
        findLcm(72, 120);
    }
    static void findLcm(int a, int b){

        int lcm = (a > b)? a : b;
        
        while(true){
            
            if(lcm%a == 0 && lcm % b == 0){
                //System.out.println(lcm);
                System.out.printf("LCM of %d and %d is %d ",a,b,lcm);
                break;
            }
            ++lcm;
        }
    }

    static long lcmArr(int[] arr){
        
        int max = arr[0];

        for(int i=0;i < arr.length;i++){

            //get the largest value in the array
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] % max == 0){

            }
        }
        return 0;
    }

}