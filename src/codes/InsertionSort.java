import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] data = { 9, 5, 1, 4, 3 };
        InsertionSort is = new InsertionSort();
        //is.insertionSort(data);
        is.insertionSort2(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
    
    void insertionSort(int[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            int key = arr[i];
            int j = i - 1;
            //Compare key with each element on the left of it until an element
            // smaller than it is found.
            // For descending order, change key < arr[j] to k > arr[j]
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                --j;
            }
            // place key at after the element just smaller than it
            arr[j + 1] = key;
        }
    }
    
    static int[] insertionSort2(int[] array) {
        if (array.length == 0)
            return new int[] {};
        
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap(j, j - 1, array);
                j -= 1;
            }
        }
        return array;
    }
    static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
