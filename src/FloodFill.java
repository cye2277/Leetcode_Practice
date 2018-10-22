import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    //An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
    //Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
    //To perform a "flood fill", consider the starting pixel,
    //plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
    //plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on.
    // Replace the color of all of the aforementioned pixels with the newColor.

    //Input:
    //image = [[1,1,1],[1,1,0],[1,0,1]]
    //sr = 1, sc = 1, newColor = 2

    //Output: [[2,2,2],[2,2,0],[2,0,1]]

    //Explanation:
    //From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
    //by a path of the same color as the starting pixel are colored with the new color.
    //Note the bottom corner is not colored 2, because it is not 4-directionally connected
    //to the starting pixel.

    public static void main(String[] args) {

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        int r = image.length;
        int c = image[0].length;
        boolean[][] visited = new boolean[r][c];
        for (int i= 0; i<visited.length;i++){
            for (int j = 0; j<visited.length;j++){
                visited[r][c] = false;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        int[] dr = new int[]{1,-1,0,0};
        int[] dc = new int[]{0,0,1,-1};
        image[sr][sc] = newColor;
        queue.add(new int[]{sr,sc});
        visited[sr][sc] = true;

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            for (int i =0 ; i < 4; i++){
                int nextR = curr[0]+dr[i];
                int nextC = curr[1]+dc[i];
                if (nextR >=0 && nextR <= r && nextC >= 0 && nextC <= c && visited[nextR][nextC] == false ){
                    image[nextR][nextC] = newColor;
                    visited[nextR][nextC] = true;
                    queue.offer(new int[]{nextR,nextC});
                }
            }
        }
        return image;
    }
}
