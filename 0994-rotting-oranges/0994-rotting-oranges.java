import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Phase 1: Scan the grid to initialize our trackers
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c}); // Found a starting source of rot!
                } else if (grid[r][c] == 1) {
                    freshCount++; // Count the healthy oranges we need to save
                }
            }
        }
        
        // If there are no fresh oranges to begin with, we are already done!
        if (freshCount == 0) return 0;
        
        int minutes = 0;
        // Handy tool to walk Up, Down, Left, Right seamlessly
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Phase 2: The Multi-Source BFS Engine
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size(); // Freeze the frame: how many rotten oranges are acting THIS minute?
            minutes++; // A new minute begins as this batch spreads rot
            
            // Process all rotten oranges currently on this specific time level
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currRow = current[0];
                int currCol = current[1];
                
                // Check all 4 neighboring directions
                for (int[] dir : directions) {
                    int nextRow = currRow + dir[0];
                    int nextCol = currCol + dir[1];
                    
                    // Boundary check: Is the neighbor inside the grid boundaries?
                    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                        // Is it a fresh orange?
                        if (grid[nextRow][nextCol] == 1) {
                            grid[nextRow][nextCol] = 2; // It rots!
                            freshCount--; // One less fresh orange remaining
                            queue.offer(new int[]{nextRow, nextCol}); // It will spread rot next minute
                        }
                    }
                }
            }
        }
        
        // Phase 3: The Verdict
        // If freshCount is 0, we successfully rotted everything. Otherwise, it's impossible.
        return freshCount == 0 ? minutes : -1;
    }
}