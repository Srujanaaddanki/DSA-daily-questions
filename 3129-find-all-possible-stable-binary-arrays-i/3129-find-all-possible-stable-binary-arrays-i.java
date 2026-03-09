class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1_000_000_007;
        
        // dp[i][j][0] -> ends with 0
        // dp[i][j][1] -> ends with 1
        long[][][] dp = new long[zero + 1][one + 1][2];

        // 1. Base Cases: If we only have 0s or only have 1s
        // We can make exactly 1 valid array as long as we don't exceed the limit
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }

        // 2. Build the DP table
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                
                // --- Calculate for arrays ending in 0 ---
                // Add a 0 to all valid previous arrays
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                
                // Subtract the ones that just exceeded the limit
                if (i > limit) {
                    // We add MOD before applying % MOD to prevent negative numbers in Java!
                    dp[i][j][0] = (dp[i][j][0] - dp[i - limit - 1][j][1] + MOD) % MOD;
                }

                // --- Calculate for arrays ending in 1 ---
                // Add a 1 to all valid previous arrays
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                
                // Subtract the ones that just exceeded the limit
                if (j > limit) {
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j - limit - 1][0] + MOD) % MOD;
                }
            }
        }

        // 3. The answer is the sum of arrays ending in 0 AND arrays ending in 1
        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}