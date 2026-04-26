class Solution {
    // 4 directions: Right, Down, Left, Up
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    boolean[][] visited;

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        
        // Sweep through every single cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If we haven't explored this cell's component yet, start a DFS!
                if (!visited[i][j]) {
                    // We pass -1, -1 as the parent because the starting cell has no parent
                    if (dfs(grid, i, j, -1, -1, grid[i][j])) {
                        return true; 
                    }
                }
            }
        }
        
        return false;
    }

    private boolean dfs(char[][] grid, int x, int y, int parentX, int parentY, char targetChar) {
        // Mark the current cell as visited
        visited[x][y] = true;
        
        // Explore all 4 adjacent directions
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            // 1. Is the next step out of bounds?
            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                continue;
            }
            
            // 2. Does the next step match our character?
            if (grid[nextX][nextY] != targetChar) {
                continue;
            }
            
            // 3. Have we NOT visited it yet? Take a step forward!
            if (!visited[nextX][nextY]) {
                // Now, WE (x, y) become the parent for the next step
                if (dfs(grid, nextX, nextY, x, y, targetChar)) {
                    return true;
                }
            } 
            // 4. We HAVE visited it! Is it the cell we just came from?
            else if (nextX != parentX || nextY != parentY) {
                // It's a visited cell, but it's NOT our parent. We found a cycle!!
                return true;
            }
        }
        
        return false;
    }
}