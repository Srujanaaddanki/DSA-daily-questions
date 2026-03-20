class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        // The result array size is always (m - k + 1) x (n - k + 1)
        int[][] ans = new int[m - k + 1][n - k + 1];
        
        // Loop through every valid top-left corner of a k x k submatrix
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                
                // Step 1: Collect all elements in this specific submatrix
                List<Integer> nums = new ArrayList<>();
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        nums.add(grid[x][y]);
                    }
                }
                
                // Step 2: Sort the elements so closest values are adjacent
                Collections.sort(nums);
                
                // Step 3: Find the minimum difference between DISTINCT elements
                int minDiff = Integer.MAX_VALUE;
                for (int t = 1; t < nums.size(); t++) {
                    int curr = nums.get(t);
                    int prev = nums.get(t - 1);
                    
                    if (curr != prev) {
                        // Because the list is sorted, curr is always >= prev. 
                        // No need for Math.abs()!
                        minDiff = Math.min(minDiff, curr - prev);
                    }
                }
                
                // Step 4: Handle the edge case where all elements were identical
                if (minDiff == Integer.MAX_VALUE) {
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = minDiff;
                }
            }
        }
        
        return ans;
    }
}