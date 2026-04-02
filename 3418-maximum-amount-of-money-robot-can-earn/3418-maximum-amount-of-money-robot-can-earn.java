class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        
        // dp[i][j][k] = max coins at cell (i, j) having used exactly k neutralizations
        int[][][] dp = new int[m][n][3];
        
        // We use a very small number for invalid paths to prevent Math.max() from picking them.
        // We don't use Integer.MIN_VALUE to avoid integer underflow when adding negative coins!
        int MIN = -1000000000; 
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = MIN;
                dp[i][j][1] = MIN;
                dp[i][j][2] = MIN;
            }
        }
        
        // Base Case: The Starting Cell
        dp[0][0][0] = coins[0][0]; 
        if (coins[0][0] < 0) {
            // If the start is a robber, we can choose to immediately spend 1 neutralization!
            dp[0][0][1] = 0; 
        }
        
        // Fill the 3D DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Skip the starting cell
                if (i == 0 && j == 0) continue;
                
                int val = coins[i][j];
                
                // Calculate for all possible states of k (0, 1, and 2)
                for (int k = 0; k < 3; k++) {
                    
                    // Option 1: Do NOT neutralize current cell
                    if (i > 0 && dp[i - 1][j][k] != MIN) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k] + val);
                    }
                    if (j > 0 && dp[i][j - 1][k] != MIN) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k] + val);
                    }
                    
                    // Option 2: NEUTRALIZE current cell (Only if it's negative AND we have neutralizations left)
                    if (val < 0 && k > 0) {
                        if (i > 0 && dp[i - 1][j][k - 1] != MIN) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k - 1]); // Add 0 instead of val
                        }
                        if (j > 0 && dp[i][j - 1][k - 1] != MIN) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k - 1]); // Add 0 instead of val
                        }
                    }
                }
            }
        }
        
        // Return the absolute maximum out of all 3 parallel realities at the finish line!
        return Math.max(dp[m - 1][n - 1][0], Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}