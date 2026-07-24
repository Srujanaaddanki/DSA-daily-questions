class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Base Case 1: If start or end cell is blocked (1), no path exists
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        // Base Case 2: A 1x1 grid with a clear start cell takes 1 cell length
        if (n == 1) {
            return 1;
        }

        // All 8 possible directions (Horizontal, Vertical, Diagonal)
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };

        // Queue stores [row, col, pathLength]
        Queue<int[]> queue = new LinkedList<>();
        
        // Start BFS from top-left (0,0) with path length = 1
        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1; // Mark start as visited

        // BFS Engine
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];

            // Explore all 8 neighbors
            for (int[] dir : directions) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];

                // Check grid boundaries and see if neighbor is a clear path (0)
                if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && grid[nextR][nextC] == 0) {
                    
                    // Destination reached! Return path length
                    if (nextR == n - 1 && nextC == n - 1) {
                        return dist + 1;
                    }

                    // Mark as visited instantly to prevent duplicate processing
                    grid[nextR][nextC] = 1;
                    
                    // Push neighbor onto queue with updated distance
                    queue.offer(new int[]{nextR, nextC, dist + 1});
                }
            }
        }

        // Queue emptied without reaching destination
        return -1;
    }
}