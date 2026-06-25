class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;      
        // Shrink the container inward until the pointers meet
        while (left < right) {
            // 1. Calculate the width (distance between indices)
            int width = right - left;            
            // 2. Find the limiting height (the shorter wall)
            int currentHeight = Math.min(height[left], height[right]);          
            // 3. Calculate current area and update our absolute maximum
            int currentWater = width * currentHeight;
            maxWater = Math.max(maxWater, currentWater);           
            // 4. Move the pointer that is holding us back (the shorter one)
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }        
        return maxWater;
    }
}