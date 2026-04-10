class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        
        // Since 1 <= nums[i] <= n, an array of size n + 1 is perfect for O(1) lookups
        int[] first = new int[n + 1];
        int[] second = new int[n + 1];
        
        // Initialize our tracking arrays to -1 (meaning "not seen yet")
        for (int i = 0; i <= n; i++) {
            first[i] = -1;
            second[i] = -1;
        }
        
        int minDistance = Integer.MAX_VALUE;
        
        // Sweep through the array exactly once
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            
            if (first[val] == -1) {
                // First time seeing this number
                first[val] = i;
            } else if (second[val] == -1) {
                // Second time seeing this number
                second[val] = i;
            } else {
                // Third time! We have a valid consecutive tuple.
                int currentDistance = 2 * (i - first[val]);
                minDistance = Math.min(minDistance, currentDistance);
                
                // Slide the window forward so we are ready if we see the number a 4th time
                first[val] = second[val];
                second[val] = i;
            }
        }
        
        // If we never found a triplet, return -1 as required
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}