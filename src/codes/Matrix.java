public class Matrix {
    static int[][] data;
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
        transposeMatrix(matrix);
        spiralMatrix(matrix);
    }
    static void transposeMatrix(int[][] matrix) {
        int col = matrix[0].length;
        int rows = matrix.length;
        
        int[][] temp = new int[col][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                temp[j][i] = matrix[i][j];
            }
        }
        print(temp);
    }
    
    static void print(int[][] matrix) {
        int col = matrix[0].length;
        int rows = matrix.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] +" ");
            }
        }
        System.out.println();
    }
    
    static void spiralMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        //Define the boundaries of the matrix
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        
        //define the direction into which the array is to be traversed.
        int dir = 1;
        
        while (top <= bottom && left <= right) {
            if (dir == 1) { //moving left -> right
                for (int i = left; i <= right; ++i) {
                    System.out.println(matrix[top][i] + " ");
                }
                // Since we have traversed the whole first row, move down to the next row.
                ++top;
                dir = 2;
            } else if (dir == 2) { //moving top to bottom
                for (int i  = top; i <= bottom; ++i) {
                    System.out.println(matrix[i][right] + " ");
                }
                // since we have traversed the whole last column, move left to the previous column
                --right;
                dir = 3;
            } else if (dir == 3) { //moving right to left
                for (int i = right; i >= left; --i) {
                    System.out.println(matrix[bottom][i] + " ");
                }
                //Since we have traversed the whole last row, move up to the previous row.
                --bottom;
                dir = 4;
            } else if (dir == 4) { //moving bottom up
                for (int i = bottom; i >= top; --i) {
                    System.out.println(matrix[i][left] + " ");
                }
                // Since we have traversed the whole first col, move right to the next column
                ++left;
                dir = 1;
            }
        }
    }
}
