class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                // 1. Add the submatrix sum from the cell directly above
                if (i > 0) {
                    grid[i][j] += grid[i - 1][j];
                }
                
                // 2. Add the submatrix sum from the cell directly to the left
                if (j > 0) {
                    grid[i][j] += grid[i][j - 1];
                }
                
                // 3. Subtract the overlapping diagonal region we accidentally double-counted
                if (i > 0 && j > 0) {
                    grid[i][j] -= grid[i - 1][j - 1];
                }

                // 4. Check if this completed submatrix is valid!
                if (grid[i][j] <= k) {
                    count++;
                } else {
                    // Micro-optimization: Because all numbers are non-negative, 
                    // if the sum is already > k, moving further right will only make it bigger.
                    // We can safely break the inner loop and move to the next row!
                    break;
                }
            }
        }

        return count;
    }
}