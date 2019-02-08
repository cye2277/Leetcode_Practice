public class MinFallingPathSum {
    //Given a square array of integers A, we want the minimum sum of a falling path through A.
    //
    //A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.
    //
    //
    //
    //Example 1:
    //
    //Input: [[1,2,3],[4,5,6],[7,8,9]]
    //Output: 12
    //Explanation:
    //The possible falling paths are:
    //[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
    //[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
    //[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
    //The falling path with the smallest sum is [1,4,7], so the answer is 12.
    //
    //
    //
    //Note:
    //
    //1 <= A.length == A[0].length <= 100
    //-100 <= A[i][j] <= 100


    public int minFallingPathSum(int[][] A) {
        int N = A.length;
        for (int r = N-2; r >= 0; --r) { //from the second last row, if we have 3 row, we will start at 2.
            for (int c = 0; c < N; ++c) { //go throw each column
                // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
                int best = A[r+1][c]; //assign the downward number to max
                if (c > 0)
                    best = Math.min(best, A[r+1][c-1]); //compare with the right down number
                if (c+1 < N)
                    best = Math.min(best, A[r+1][c+1]); //compare with the left down number
                A[r][c] += best; //rewrite the value to the updated so far minimum sum
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x: A[0])
            ans = Math.min(ans, x);
        return ans;
    }
}
