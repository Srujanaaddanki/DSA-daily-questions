class Solution {
    public int minRemovals(int[] nums, int target) {
        int MAX_XOR = 16384;
        int[] dp = new int[MAX_XOR];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int num : nums){
            int[] nextDp = dp.clone();
            for(int i=0;i< MAX_XOR; i++){
                if(dp[i] != -1){
                    nextDp[i^num] = Math.max(nextDp[i^num], dp[i]+1);
            }
        }
            dp = nextDp;
        }
        if(dp[target] == -1){
            return -1;
        }
        return nums.length - dp[target];
    }
}