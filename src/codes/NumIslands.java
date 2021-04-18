public class NumIslands {
    public static void main(String[] args) {
    char[][] islands = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    numIslands(islands);
    }
    
    public static int numIslands(char[][] grid) {
        int count = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count += 1;
                    callBfs(grid, i, j);
                }
            }
        }
        System.out.println(count);
        return count;
    }
    
   static void callBfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        callBfs(grid, i+1, j);//up
        callBfs(grid, i-1,j);//down
        callBfs(grid, i, j-1);//left
        callBfs(grid,i, j+1);//right
    }
}
