public class TransposeMatrix {
    public int[][] transpose(int[][] A) {

        //Given a matrix A, return the transpose of A.
        //
        //The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
        //
        //
        //
        //Example 1:
        //
        //Input: [[1,2,3],[4,5,6],[7,8,9]]
        //Output: [[1,4,7],[2,5,8],[3,6,9]]
        //Example 2:
        //
        //Input: [[1,2,3],[4,5,6]]
        //Output: [[1,4],[2,5],[3,6]]

        //Time complexity:O(R*C)
        //Space complexity:O(R*C)
        int[][] ans = new int[A[0].length][A.length];
        for (int i = 0; i< A.length;i++){
            for (int j = 0; j < A[0].length;j++ ){
                ans[j][i] = A[i][j];
            }
        }
        return ans;
    }
}
