class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        // Find the fastest worker to set a realistic upper bound
        long minTime = workerTimes[0];
        for (int w : workerTimes) {
            minTime = Math.min(minTime, w);
        }
        
        // Boundaries for Binary Search
        long low = 1;
        // Worst case: The fastest worker does the entire mountain alone
        long high = minTime * (long) mountainHeight * (mountainHeight + 1) / 2;
        long ans = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (canDestroy(mountainHeight, workerTimes, mid)) {
                ans = mid;      // It's possible! Save this answer...
                high = mid - 1; // ...and see if we can do it even faster!
            } else {
                low = mid + 1;  // Not enough time, we must allow more seconds
            }
        }
        
        return ans;
    }
    
    // Helper function: Can all workers combined destroy the mountain in 'timeLimit' seconds?
    private boolean canDestroy(int mountainHeight, int[] workerTimes, long timeLimit) {
        long totalReduced = 0;
        
        for (int w : workerTimes) {
            // The quadratic formula to instantly find levels destroyed by this worker
            long levels = (long) ((-1.0 + Math.sqrt(1.0 + 8.0 * timeLimit / w)) / 2.0);
            totalReduced += levels;
            
            // If we already destroyed the mountain, no need to check the rest of the workers!
            if (totalReduced >= mountainHeight) {
                return true;
            }
        }
        
        return false;
    }
}