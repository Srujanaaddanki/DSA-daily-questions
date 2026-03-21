class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        // Step 1: Set the top and bottom row pointers for our specific submatrix
        int top = x;
        int bottom = x + k - 1;
        
        // Step 2: Squeeze the pointers together to flip the rows
        while (top < bottom) {
            
            // Step 3: Swap the elements column by column within our square
            for (int j = y; j < y + k; j++) {
                int temp = grid[top][j];
                grid[top][j] = grid[bottom][j];
                grid[bottom][j] = temp;
            }
            
            // Step 4: Move the pointers inward for the next flip
            top++;
            bottom--;
        }
        
        // We modified the grid directly in-place, so just hand it back!
        return grid;
    }
}