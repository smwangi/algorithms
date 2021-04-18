
public class NumOfOffices {
    private static int column, row;
    public static void main(String[] args) {
        int[][] twoDArr = {
                {1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}};
        int colIndex = 0;
        for (int x=1;x<twoDArr[0].length;x++){
            if (twoDArr[0][x] == 1 && twoDArr[0][x-1] != 1){
                colIndex++;
            }
        }
        for (int i=1;i< twoDArr.length;i++){

                for (int j = 0;j<twoDArr[0].length;j++){
                    if(twoDArr[i][j] == 1 && twoDArr[i][j-1] !=1 && twoDArr[i-1][j] != 1){
                       // System.out.println("1");
                        //break;
                        colIndex++;
                    }
                    //j++;
                }
            //}

        }
        System.out.println(colIndex);
        System.out.println(numIslands(twoDArr));
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < column && y >= 0 && y < row;
    }

    public static void dfs(int[][] grid, int x, int y) {
        grid[x][y] = '0';
        for(int i = 0; i < 4; ++i) {
           for(int j=0;j<5;j++) {
                int[]cx = grid[i];
                int[]cy=grid[j];

               int tx = x + cx[i], ty = y + cy[i];
               if (check(tx, ty) && grid[tx][ty] == '1') {
                   dfs(grid, tx, ty);
               }
           }
        }
    }

    public static int numIslands(int[][] grid) {

        column = grid.length;
        if(column < 1) return 0;
        row = grid[0].length;

        int ans = 0;
        for(int i = 0; i < column; ++i) {
            for(int j = 0; j < row; ++j) {
                if(grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }

        return ans;
    }
}
