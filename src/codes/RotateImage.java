import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        Arrays.stream(rotateImage(a)).forEach(x -> System.out.println( Arrays.toString(x)));
    }

    static int[][] rotateImage(int[][]a){
        int rowLen = a.length;
        int colLen = a[0].length;

        int[][] temp = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++){
            for(int j = 0; j< colLen;j++){
                temp[i][j] = a[rowLen-j-1][i];
            }
        }
        return temp;
    }
}
