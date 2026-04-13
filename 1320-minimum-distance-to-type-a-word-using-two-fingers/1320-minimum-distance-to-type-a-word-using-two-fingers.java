import java.util.Arrays;

class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        // dp[other_finger] stores the min distance. 
        // 26 represents the "hovering" state (finger hasn't touched a key yet).
        int[] dp = new int[27];
        Arrays.fill(dp, 0);

        for (int i = 0; i < n - 1; i++) {
            int curr = word.charAt(i) - 'A';
            int next = word.charAt(i + 1) - 'A';
            int[] nextDp = new int[27];
            Arrays.fill(nextDp, Integer.MAX_VALUE / 2);

            for (int other = 0; other <= 26; other++) {
                if (dp[other] == Integer.MAX_VALUE / 2) continue;

                // Option 1: Move the finger that is currently at 'curr' to 'next'
                nextDp[other] = Math.min(nextDp[other], dp[other] + dist(curr, next));

                // Option 2: Move the 'other' finger to 'next'
                // If other == 26, it's the first move for this finger (cost is 0)
                int d = (other == 26) ? 0 : dist(other, next);
                nextDp[curr] = Math.min(nextDp[curr], dp[other] + d);
            }
            dp = nextDp;
        }

        int minDistance = Integer.MAX_VALUE;
        for (int d : dp) minDistance = Math.min(minDistance, d);
        return minDistance;
    }

    private int dist(int a, int b) {
        int r1 = a / 6, c1 = a % 6;
        int r2 = b / 6, c2 = b % 6;
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}