import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(bubbleSort(arr)));
        int arr2[] = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.println(Arrays.toString(bubbleSort2(arr2)));
    }
    static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        boolean isSorted = false;
        int counter = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1, array);
                    isSorted = false;
                }
            }
            counter++;
        }
        return array;
    }
    static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
    
    static int[] bubbleSort2(int[] arr) {
        int i, j, temp, n = arr.length;
        boolean swapped;
        
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) { // swapp
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                // if no two elements were swapped by inner loop, then break
            }
            if (swapped == false)
                break;
        }
        return arr;
    }
}
