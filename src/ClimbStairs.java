public class ClimbStairs {
    //You are climbing a stair case. It takes n steps to reach to the top.
    //
    //Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    //
    //Note: Given n will be a positive integer.
    //
    //Example 1:
    //
    //Input: 2
    //Output: 2
    //Explanation: There are two ways to climb to the top.
    //1. 1 step + 1 step
    //2. 2 steps
    //Example 2:
    //
    //Input: 3
    //Output: 3
    //Explanation: There are three ways to climb to the top.
    //1. 1 step + 1 step + 1 step
    //2. 1 step + 2 steps
    //3. 2 steps + 1 step


    //brute force
    //Time complexity:O(2^n)
    //Space complexity:O(n)
    public int climbstairs(int n){
        return climb(0,n);
    }

    public int climb(int k, int n){
        if (k>n){
            return 0
        }
        if (k == n){
            return 1;
        }

        return climb(k+1,n)+climb(k+2, n);
    }


    //Recursion with memoization
    //time complexity:O(N)
    //space complexity:O(N)
    public int climbstairs2(int n){
        int[] memo = new int[n+1];
        return climb(0,n,memo);
    }
    public int climb(int k, int n, int[] memo){
        if (k>n){
            return 0
        }
        if (k == n){
            return 1;
        }
        if (memo[k] >0){
            return memo[k];
        }
        memo[k] =  climb(k+1,n,memo)+climb(k+2, n,memo)
        return memo[k];
    }

    //dynamic programing
    //time complexity:O(N)
    //space complexity:O(N)
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //Fibananci
    //time complexity:O(N)
    //space complexity:O(1)
    public int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

}
