import java.util.HashMap;
import java.util.Map;

/**
 * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
 *
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: true
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 *
 * Example 2:
 *
 * Input: matrix = [[1,2],[2,2]]
 * Output: false
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 *
 * Constraints:
 *
 *     m == matrix.length
 *     n == matrix[i].length
 *     1 <= m, n <= 20
 *     0 <= matrix[i][j] <= 99
 *
 * Follow up:
 *
 *     What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
 *     What if the matrix is so large that you can only load up a partial row into the memory at once?
 */
public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][]matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        isToeplitzMatrix(matrix);
    }
    /**
     * Group by category
     * We ask what feature makes two coordinates (r1, c1) and (r2, c2) belong to the same diagonal?
     *
     * It turns out two coordinates are on the same diagonal if and only if r1 - c1 == r2 - c2.
     *
     * This leads to the following idea: remember the value of that diagonal as groups[r-c].
     * If we see a mismatch, the matrix is not Toeplitz; otherwise it is.
     */
    public static boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer,Integer> groups = new HashMap<>();
        for(int r = 0; r < matrix.length;++r){
            for (int c = 0; c < matrix[0].length;++c){
                System.out.println("r "+r+" c "+c+" r-c "+(r-c)+" matrix "+matrix[r][c]);
                if(!groups.containsKey(r-c))
                    groups.put(r-c,matrix[r][c]);
                else if(groups.get(r-c) != matrix[r][c])
                    return false;
            }
        }
        return true;
    }
    /**
     * Approach #2: Compare With Top-Left Neighbor
     * For each diagonal with elements in order a1,a2,a3,…,aka_1, a_2, a_3,..., a_k, we can check a1=a2,a2=a3,…,ak−1=ak,...., a_{k-1} = a_k.
     * The matrix is Toeplitz if and only if all of these conditions are true for all (top-left to bottom-right) diagonals.
     *
     * Every element belongs to some diagonal, and it's previous element (if it exists) is it's top-left neighbor.
     * Thus, for the square (r, c), we only need to check r == 0 OR c == 0 OR matrix[r-1][c-1] == matrix[r][c]
     */
    public static boolean isToeplitzMatrix1(int[][] matrix) {
        for(int r=0; r<matrix.length;++r){
            for (int c = 0;c<matrix[0].length;++c){
                if(r>0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])return false;
            }
        }
        return true;
    }
}
