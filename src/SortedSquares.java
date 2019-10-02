import java.util.Arrays;

public class SortedSquares {
    //Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
    //
    //
    //
    //Example 1:
    //
    //Input: [-4,-1,0,3,10]
    //Output: [0,1,9,16,100]
    //Example 2:
    //
    //Input: [-7,-3,2,3,11]
    //Output: [4,9,9,49,121]
    //
    //
    //Note:
    //
    //1 <= A.length <= 10000
    //-10000 <= A[i] <= 10000
    //A is sorted in non-decreasing order.

    //Time complexity:O(NLogN)
    //Space complexity:O(N)
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i)
            ans[i] = A[i] * A[i];

        Arrays.sort(ans);
        return ans;
    }


    //Time complexity:O(N)
    //Space Complexity:O(N)
    public int[] sortedSquares1(int[] A) {
        int N = A.length;
        int i = 0;
        int j = N-1;
        int k = N-1;
        int[] ans = new int[N];
        while (i < j){
            if (Math.abs(A[j]) > Math.abs(A[i])){
                ans[k--] = A[j] *A[j];
                j--;
            }else{
                ans[k--] = A[i] *A[i];
                i++;
            }
        }
        ans[0] = A[i] * A[i];
        return ans;
    }
}
