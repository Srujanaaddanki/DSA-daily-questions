class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;

        long[][] preSum = new long[2][n + 1];

        for (int i = 0; i < n; i++) {
            preSum[0][i + 1] = preSum[0][i] + grid[i][0];
        }

        long[][][] dp = new long[2][n + 1][2];

        int prev = 0, curr = 1;

        for (int col = 0; col < n - 1; col++) {

            for (int i = 0; i < n; i++) {
                preSum[curr][i + 1] = preSum[curr][i] + grid[i][col + 1];
            }

            long preMax = dp[prev][0][1];

            for (int k = 1; k <= n; k++) {
                long best = Math.max(
                    dp[prev][k][0],
                    preMax + preSum[prev][k]
                );

                dp[curr][k][0] = best;
                dp[curr][k][1] = best;

                preMax = Math.max(preMax,
                        dp[prev][k][1] - preSum[prev][k]);
            }
            long sufMax = dp[prev][n][0] + preSum[curr][n];

            for (int k = n - 1; k > 0; k--) {
                dp[curr][k][0] = Math.max(
                    dp[curr][k][0],
                    sufMax - preSum[curr][k]
                );

                sufMax = Math.max(sufMax,
                        dp[prev][k][0] + preSum[curr][k]);
            }
            dp[curr][0][0] = sufMax;
            dp[curr][0][1] = Math.max(dp[prev][0][0], dp[prev][n][0]);

            int temp = prev;
            prev = curr;
            curr = temp;
        }

        long ans = 0;
        for (int k = 0; k <= n; k++) {
            ans = Math.max(ans, dp[prev][k][0]);
            ans = Math.max(ans, dp[prev][k][1]);
        }

        return ans;
    }
}