package codes;

import java.util.Arrays;

/**
 * Step 1 :  Sort the given array first using the function sort.
 * Step 2 : Instead of storing the numbers store the square of each element to directly check the Pythagorean theorem.
 * Step 3 : Take a as the smallest side, for every a check the elements from the array which satisfy the condition (a = c – b).
 * if they satisfy this condition they form Pythagorean triplet as they satisfy the condition
 * a2 + b2 = c2
 * a.    for all elements in the array from start, store the first element as “a”.
 * b.    store the last two elements as “b” and “c” respectively.
 * c.    Check the condition “a = c – b”. if true print the sqrts of a, b, c as a set of Pythagorean triplets.
 * d.    If “c – b” is greater than “a”, decrease the variable pointing at the larger element(c) so that we are checking for all “c” is this condition true or not.
 *       If “c – b” is less than a decrease the variable pointing at the smaller element so that we are checking for all b is this condition true or not.
 * e.    continue this loop for all a`s
 * f.    If not found any, print no triplets.
 */
public class PythagoreanTripples {

    public static void main(String[] args) {
        int[] array = {3,7, 2,24,12,1,5,6,4,9,13,10,25};
        int a,b,c;
        int size = array.length;
        int N = array.length;

        //Assuming a is the shortest side.
        Arrays.sort(array);
        for (int i = 0; i < array.length;i++)
            array[i] = array[i]*array[i];



        /*for(int i = 0; i< N;i++){
            int left = N-2, right = N-1;
            System.out.println("Left: "+left+" Right: "+right);
            a = array[i];
            while (left > i){
                b = left;
                c = right;

                int calculatedShortSide = c-b;//If a*a + b*b = c*c, then c*c - b*b = a*a;
                if(calculatedShortSide == a){
                    System.out.format("Pythagorean Trippe %d, %d, %d ",a,b,c);
                    System.out.println();
                    left++;
                    right--;
                }else if(calculatedShortSide > a){//if side is larger than expected then decrease  the variable pointing at the larger element
                    right--;
                }else{// if side is smaller than expected then decrease the variable pointing at the smaller element
                    left--;
                }
            }
        }*/

        Arrays.stream(array).forEach(t -> System.out.print(t+" "));
        System.out.println();
        for(int i = N-1;i >=2;i--){
            int n_1 = N-1;
            System.out.println("i "+i+" N-1 "+n_1+" arr[i] "+array[i]);
            // To find the other two elements, start two index
            // variables from two corners of the array and move
            // them toward each other
            int l = 0; // index of the first element in arr[0..i-1]
            int r = i - 1; // index of the last element in arr[0..i-1]
            while (l < r){
                if(array[l]+array[r] == array[i]){
                    System.out.format("Pythagorean Triplets %d, %d, %d ",array[l],array[r],array[i]);
                    System.out.println();
                    break;
                }else if(array[l]+array[r] < array[i]){
                    l++;
                }else{
                    r--;
                }
            }
        }

    }
}
