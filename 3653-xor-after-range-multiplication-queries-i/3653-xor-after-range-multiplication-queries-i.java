class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1_000_000_007;
        
        // Process each query
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int step = query[2];
            long multiplier = query[3]; // Use long to prevent overflow during multiplication

            for (int i = left; i <= right; i += step) {
                // Perform multiplication and apply modulo
                long updatedVal = (1L * nums[i] * multiplier) % mod;
                nums[i] = (int) updatedVal;
            }
        }

        // Calculate final XOR sum
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }

        return xorResult;
    }
}