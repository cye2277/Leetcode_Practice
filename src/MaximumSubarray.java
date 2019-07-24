public class MaximumSubarray {
    //Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
    //
    //Example:
    //
    //Input: [-2,1,-3,4,-1,2,1,-5,4],
    //Output: 6
    //Explanation: [4,-1,2,1] has the largest sum = 6.
    //Follow up:
    //
    //If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

    //dyanmic programing
    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
