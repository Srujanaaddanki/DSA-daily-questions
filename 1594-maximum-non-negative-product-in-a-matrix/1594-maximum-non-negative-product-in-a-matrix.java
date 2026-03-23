class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;
        
        // dp[i][j][0] will store the MAXIMUM product up to cell (i, j)
        // dp[i][j][1] will store the MINIMUM product up to cell (i, j)
        long[][][] dp = new long[m][n][2];
        
        // Base Case: The start cell
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        
        // Initialize the first column (can only come from above)
        for (int i = 1; i < m; i++) {
            dp[i][0][0] = dp[i - 1][0][0] * grid[i][0];
            dp[i][0][1] = dp[i - 1][0][1] * grid[i][0];
        }
        
        // Initialize the first row (can only come from the left)
        for (int j = 1; j < n; j++) {
            dp[0][j][0] = dp[0][j - 1][0] * grid[0][j];
            dp[0][j][1] = dp[0][j - 1][1] * grid[0][j];
        }
        
        // Fill the rest of the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                
                // Calculate all 4 possible products coming into this cell
                long p1 = dp[i - 1][j][0] * grid[i][j]; // Top Max
                long p2 = dp[i - 1][j][1] * grid[i][j]; // Top Min
                long p3 = dp[i][j - 1][0] * grid[i][j]; // Left Max
                long p4 = dp[i][j - 1][1] * grid[i][j]; // Left Min
                
                // Find the new Max and Min
                dp[i][j][0] = Math.max(Math.max(p1, p2), Math.max(p3, p4));
                dp[i][j][1] = Math.min(Math.min(p1, p2), Math.min(p3, p4));
            }
        }
        
        // The final max product is at the bottom-right corner
        long maxProduct = dp[m - 1][n - 1][0];
        
        // If the max product is negative, the problem says return -1
        if (maxProduct < 0) {
            return -1;
        }
        
        // Otherwise, return it modulo 10^9 + 7
        return (int) (maxProduct % MOD);
    }
}