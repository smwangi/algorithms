<<<<<<< HEAD
package codes;

import java.util.Arrays;

/**
 *
 Traverse the array and keep summing the elements and keep updating the minValue at each point.
 We set the start value = minValue*(-1) + 1 (Here minValue is the least sum value that we come across at a single point during our traversal.)
 (We add +1 to the start value because the sum should be atleast 1 and not just 0.)

 */
public class MinStartValue {

    private static int startValue = 1;
    public static void main(String[] args) {
        int[] arr = {2,3,5,-5,-1};

        System.out.println(minStartValue(arr));
        System.out.println(minStartVal(arr));
    }

    static int minStartValue(int[] nums){

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0; i < nums.length;i++){
            sum += nums[i];
            min = Math.min(min, sum);
        }
        if(min > 0)
            return 1;
        return min*(-1)+1;
    }

    static int minStartVal(int[] nums){

        int current = 1, startVal = 1;

        for(int i = 0; i < nums.length; i++){
            current +=nums[i];

            while (current < 1){
                current +=1;
                startVal +=1;
            }
        }
        return startVal;
    }

    public static int minStartValueA(int[] nums){
        //Let min start value = 1;
        int startValue = 1;
        Arrays.sort(nums);
        Arrays.stream(nums).forEachOrdered(System.out::println);
        if(nums[0] >= 1)
            return startValue;
        else {


            int i = 1;
            while (true) {
                int sum = i;
                boolean found = true;

                for (int j = 0; j < nums.length; j++) {
                    sum = sum + nums[j];
                    if (sum < 1) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    startValue = i;
                    break;
                }
                i++;
            }

        }
    System.out.println("//");
        return startValue;
    }
}
=======
package codes;

import java.util.Arrays;

/**
 *
 Traverse the array and keep summing the elements and keep updating the minValue at each point.
 We set the start value = minValue*(-1) + 1 (Here minValue is the least sum value that we come across at a single point during our traversal.)
 (We add +1 to the start value because the sum should be atleast 1 and not just 0.)

 */
public class MinStartValue {

    private static int startValue = 1;
    public static void main(String[] args) {
        int[] arr = {2,3,5,-5,-1};

        System.out.println(minStartValue(arr));
        System.out.println(minStartVal(arr));
    }

    static int minStartValue(int[] nums){

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0; i < nums.length;i++){
            sum += nums[i];
            min = Math.min(min, sum);
        }
        if(min > 0)
            return 1;
        return min*(-1)+1;
    }

    static int minStartVal(int[] nums){

        int current = 1, startVal = 1;

        for(int i = 0; i < nums.length; i++){
            current +=nums[i];

            while (current < 1){
                current +=1;
                startVal +=1;
            }
        }
        return startVal;
    }

    public static int minStartValueA(int[] nums){
        //Let min start value = 1;
        int startValue = 1;
        Arrays.sort(nums);
        Arrays.stream(nums).forEachOrdered(System.out::println);
        if(nums[0] >= 1)
            return startValue;
        else {


            int i = 1;
            while (true) {
                int sum = i;
                boolean found = true;

                for (int j = 0; j < nums.length; j++) {
                    sum = sum + nums[j];
                    if (sum < 1) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    startValue = i;
                    break;
                }
                i++;
            }

        }
    System.out.println("//");
        return startValue;
    }
}
>>>>>>> 4c481b167783801000ba9df13883a864ba95ccab
