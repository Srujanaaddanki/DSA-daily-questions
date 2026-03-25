class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        long[] rowSums = new long[m];
        long[] colSums = new long[n];
        long totalSum = 0;
        
        // Step 1: Calculate the sum of every row, every column, and the total grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSums[i] += grid[i][j];
                colSums[j] += grid[i][j];
                totalSum += grid[i][j];
            }
        }
        
        // If the total sum is odd, we can never split it into two equal integer halves
        if (totalSum % 2 != 0) {
            return false;
        }
        
        long target = totalSum / 2;
        
        // Step 2: Check for a valid Horizontal Cut (accumulate row sums)
        long currentSum = 0;
        // We go up to m - 1 because the bottom section cannot be empty!
        for (int i = 0; i < m - 1; i++) { 
            currentSum += rowSums[i];
            if (currentSum == target) {
                return true; // Found a valid horizontal cut!
            }
        }
        
        // Step 3: Check for a valid Vertical Cut (accumulate col sums)
        currentSum = 0;
        // We go up to n - 1 because the right section cannot be empty!
        for (int j = 0; j < n - 1; j++) { 
            currentSum += colSums[j];
            if (currentSum == target) {
                return true; // Found a valid vertical cut!
            }
        }
        
        // If neither cut works, it's impossible
        return false;
    }
}