import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class OrangeRotting {
    //In a given grid, each cell can have one of three values:
    //
    //the value 0 representing an empty cell;
    //the value 1 representing a fresh orange;
    //the value 2 representing a rotten orange.
    //Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
    //
    //Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

    //Example 1:
    //
    //
    //
    //Input: [[2,1,1],[1,1,0],[0,1,1]]
    //Output: 4
    //Example 2:
    //
    //Input: [[2,1,1],[0,1,1],[1,0,1]]
    //Output: -1
    //Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
    //Example 3:
    //
    //Input: [[0,2]]
    //Output: 0
    //Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
    //
    //
    //Note:
    //
    //1 <= grid.length <= 10
    //1 <= grid[0].length <= 10
    //grid[i][j] is only 0, 1, or 2.

    public int orangesRotting(int[][] grid) {
        int[] dr = new int[]{1,-1,0,0};
        int[] dc = new int[]{0,0,1,-1};
        int R = grid.length, C = grid[0].length;

        Queue<Integer> queue = new ArrayDeque<>();
        HashMap<Integer, Integer> depth = new HashMap<>();
        for (int r =0; r<R;r++){
            for (int c = 0; c<C; c++){
                if (grid[r][c]== 2){
                    int num = r*C+c;
                    queue.add(num);
                    depth.put(num,0);
                }
            }
        }

        int ans =0;
        while (!queue.isEmpty()){
            int code = queue.remove();
            int r = code/C;
            int c = code % C ;
            for (int k = 0; k<4; k++){
                int nr = r+dr[k];
                int nc = c+dc[k];
                if (0<= nr & nr<R && 0 <= nc && nc< C && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    int ncode = nr*C + nc;
                    queue.add(ncode);
                    depth.put(ncode,depth.get(code)+1);
                    ans = depth.get(ncode);
                }
            }
        }
        for (int[] row: grid)
            for (int v: row)
                if (v == 1)
                    return -1;

        return ans;
    }
}
