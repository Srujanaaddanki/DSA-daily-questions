// Bottom up Approach

class Solution {
    public int climbStairs(int n) {
        // dp[i] = ways to reach step i+1

        // why not only "n"?
        // int[] dp = new int[n];
        // int[] dp = new int[3]; (Wrong)
        // Indices available: 0, 1, 2 
        // also return dp[3]; -> CRASH! (There is no slot #3). so we follow line 4;

        int[] dp = new int[n+1];
        dp[0] = 1;         // 1 way to stand at start
        dp[1] = 1;         // only 1 step
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
