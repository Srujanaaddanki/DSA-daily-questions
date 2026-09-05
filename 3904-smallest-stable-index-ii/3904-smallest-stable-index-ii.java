class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Precompute Suffix Minimum array
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        // Step 2: Compute Prefix Maximum on the fly and check condition
        int prefixMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);

            // Check if instability score <= k
            if (prefixMax - suffixMin[i] <= k) {
                return i; // Smallest index found
            }
        }

        return -1;
    }
}