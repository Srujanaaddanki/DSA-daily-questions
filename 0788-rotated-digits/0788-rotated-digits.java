class Solution {
    public int rotatedDigits(int n) {
        // dp[i] will store the "state" of the number i
        int[] dp = new int[n + 1];
        int count = 0;
        
        for (int i = 0; i <= n; i++) {
            // Base cases: single digit numbers
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8) {
                    dp[i] = 1; // Valid, but unchanged
                } else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2; // Good number!
                    count++;
                }
            } 
            // DP Transition: numbers >= 10
            else {
                int prefixState = dp[i / 10];
                int lastDigitState = dp[i % 10];
                
                // If both parts are valid and unchanged, the whole is unchanged
                if (prefixState == 1 && lastDigitState == 1) {
                    dp[i] = 1;
                } 
                // If both parts are valid (>= 1), and at least one is a 'Good' digit (2)
                else if (prefixState >= 1 && lastDigitState >= 1) {
                    dp[i] = 2;
                    count++;
                }
                // Notice we do nothing if either is 0. The default int array value is 0, 
                // so it naturally stays Invalid!
            }
        }
        
        return count;
    }
}