class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Step 1: Prefix Pass (Left to Right)
        // The first element has nothing to its left, so its prefix product is 1
        result[0] = 1; 
        for (int i = 1; i < n; i++) {
            // The prefix product for 'i' is the product of everything up to 'i-1'
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Step 2: Suffix Pass (Right to Left)
        // The last element has nothing to its right, so its suffix product starts at 1
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            // Multiply the stored prefix product by the running suffix product
            result[i] = result[i] * suffixProduct;
            
            // Update the suffix product for the next element to the left
            suffixProduct = suffixProduct * nums[i];
        }
        
        return result;
    }
}