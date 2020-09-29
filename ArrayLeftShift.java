import java.util.stream.IntStream;
import java.util.*;
/**
 * ArrayLeftShift
 * 
    Firstly we declare the size of the array and create an array ” arr ” and store the elements of the array in it.
    
    Next scan the shift variable which denotes the number of times the array is supposed to be rotated.
    
    Create another array called ” temp ” and check if shift is greater than the size of the array. If so using a while loop decrement the value of shift.
    
    Then store the elements of the initial array ” arr ” in the ” temp ” array by using the logic below.
    
    In the end, print the elements in the ” temp ” array which contains the shifted elements of the initial array.

 */
public class ArrayLeftShift {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter size of the array.. ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        
        System.out.println("Enter array elements..");
        for(int i = 0; i< size;i++){
            arr[i] = scanner.nextInt();
        }

        int[] temp = new int[size];
        System.out.println("Enter number of times to shift: ");
        int shift = scanner.nextInt();

        scanner.close();

        while(shift >= size ){
            shift = shift-size;
        }

        int j = 0;

        for(int i = 0;i < size;i++){

            if(shift + i >= size){
                temp[i] = arr[j];
                j= j+1;
            }else{
                temp[i] = arr[shift+i];
            }
        }
        IntStream str = IntStream.of(temp);
        str.forEach(x -> System.out.print(x+" "));
    }
}