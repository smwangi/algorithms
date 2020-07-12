package codes;

public class HourGlass {

    public static void main(String[] args) {

        int[][] arr = {
                {1,1,1,0,0,0},
                {0,1,0,0,0,0},
                {1,1,1,0,0,0},
                {0,0,2,4,4,0},
                {0,0,0,2,0,0},
                {0,0,1,2,4,0},
        };
        hourglassSum(arr);
    }

    static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row < arr.length; row++){
            for (int col = 0;col < 3;col++){
                System.out.println(arr[row][col]+" ");
            }
            System.out.println();
        }

        return maxSum;
    }
}
