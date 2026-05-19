class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int currentF = 0;
        
        // Step 1: Calculate the total SUM and the initial F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            currentF += i * nums[i];
        }
        
        int maxF = currentF;
        
        // Step 2: Use the mathematical formula to find F(1) through F(n-1)
        for (int k = 1; k < n; k++) {
            // The element that wraps around to the front is at index (n - k)
            currentF = currentF + sum - (n * nums[n - k]);
            
            // Keep track of the absolute maximum we have seen so far
            maxF = Math.max(maxF, currentF);
        }
        
        return maxF;
    }
}