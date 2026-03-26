import java.util.*;

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long totalSum = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += grid[i][j];
            }
        }
        
        // 1. Horizontal Cut (Discount from Top)
        if (checkTop(grid, totalSum)) return true;
        
        // 2. Horizontal Cut (Discount from Bottom)
        if (checkTop(reverseRows(grid), totalSum)) return true;
        
        // 3. Vertical Cut (Discount from Left)
        int[][] transGrid = transpose(grid);
        if (checkTop(transGrid, totalSum)) return true;
        
        // 4. Vertical Cut (Discount from Right)
        if (checkTop(reverseRows(transGrid), totalSum)) return true;
        
        return false;
    }
    
    private boolean checkTop(int[][] grid, long totalSum) {
        long topSum = 0;
        Set<Integer> seen = new HashSet<>();
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Cut AFTER row i (leaving at least 1 row for the bottom section)
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols; j++) {
                topSum += grid[i][j];
                seen.add(grid[i][j]);
            }
            
            long botSum = totalSum - topSum;
            long diff = topSum - botSum; // The exact value we need to remove from Top
            
            // Perfect match without any discounts!
            if (diff == 0) return true; 
            
            // If top is bigger, we need to remove a cell exactly equal to 'diff'
            // (Max value of a grid cell is 100,000 per constraints)
            if (diff > 0 && diff <= 100000) {
                // Is this section a 2D block (>= 2 rows AND >= 2 cols)?
                boolean is2D = (i > 0) && (cols > 1);
                
                if (is2D) {
                    // In a 2D block, ANY removed cell leaves the rest connected
                    if (seen.contains((int) diff)) return true;
                } else {
                    // In a 1D line, we can ONLY remove the end points!
                    if (i == 0) {
                        // 1 Row, Multiple Columns (Ends are Left and Right)
                        if (diff == grid[0][0] || diff == grid[0][cols - 1]) return true;
                    } else { 
                        // Multiple Rows, 1 Column (Ends are Top and Bottom)
                        if (diff == grid[0][0] || diff == grid[i][0]) return true;
                    }
                }
            }
        }
        return false;
    }
    
    // --- Helper Methods ---
    
    // Flips the grid upside down (Turns "Discount from Bottom" into "Discount from Top")
    private int[][] reverseRows(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = grid[m - 1 - i][j];
            }
        }
        return res;
    }
    
    // Swaps rows and columns (Turns Vertical Cuts into Horizontal Cuts)
    private int[][] transpose(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = grid[i][j];
            }
        }
        return res;
    }
}