class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Step 1: Submerge all land connected to the left and right boundaries
        for (int r = 0; r < rows; r++) {
            if (grid[r][0] == 1) {
                dfs(grid, r, 0);
            }
            if (grid[r][cols - 1] == 1) {
                dfs(grid, r, cols - 1);
            }
        }

        // Step 2: Submerge all land connected to the top and bottom boundaries
        for (int c = 0; c < cols; c++) {
            if (grid[0][c] == 1) {
                dfs(grid, 0, c);
            }
            if (grid[rows - 1][c] == 1) {
                dfs(grid, rows - 1, c);
            }
        }

        // Step 3: Count the remaining trapped land cells
        int enclaveCount = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    enclaveCount++;
                }
            }
        }

        return enclaveCount;
    }

    // Helper DFS function to sink connected land cells
    private void dfs(int[][] grid, int r, int c) {
        // Boundary checks + stop if water (0)
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return;
        }

        // Sink the land cell so we don't visit it again
        grid[r][c] = 0;

        // Explore all 4 directions (Up, Down, Left, Right)
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}