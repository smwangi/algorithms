import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] ar1 = {1, 2, 3, 4, 5, 6};
        int[] ar2 = {1, 2, 3, 4, 5, 6};
        ReverseArray rv = new ReverseArray();
        rv.reverse1(ar1);
        rv.reverse2(ar2);
    }
    
    public int[] reverse1(int[] ar) {
        int[] temp = new int[ar.length];
        int j = 0;
        for (int i = ar.length - 1; i >=0; i--) {
            temp[j++] = ar[i];
        }
        System.out.println(Arrays.toString(temp));
        return temp;
    }
    
    //In place reverse
    public int[] reverse2(int[] ar) {
        int i, k, temp;
        for (i = 0; i < ar.length / 2; i++) {
            temp = ar[i];
            ar[i] = ar[ar.length - i - 1];
            ar[ar.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(ar));
        return ar;
    }
}
