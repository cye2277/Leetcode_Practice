public class NumIslands {
    //Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
    //
    //Example 1:
    //
    //Input:
    //11110
    //11010
    //11000
    //00000
    //
    //Output: 1
    //Example 2:
    //
    //Input:
    //11000
    //11000
    //00100
    //00011
    //
    //Output: 3

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i< grid.length;i++){
            for (int j = 0; j< grid[0].length; j++){
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int r, int c){
        if (r<0 || r>=grid.length || c< 0 || c>=grid[0].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r +1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
}
