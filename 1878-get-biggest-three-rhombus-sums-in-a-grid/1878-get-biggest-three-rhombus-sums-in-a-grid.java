import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // This will automatically keep our numbers sorted and distinct
        TreeSet<Integer> topThree = new TreeSet<>();
        
        // 1. Loop through every cell to treat it as the "Top Tip" of a rhombus
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                // Base Case: Rhombus of length 0 is just the cell itself
                topThree.add(grid[i][j]);
                if (topThree.size() > 3) topThree.pollFirst(); // Keep only top 3
                
                int L = 1; // Start expanding the side length
                
                // 2. Expand as long as the bottom, left, and right tips fit in the grid
                while (i + 2 * L < m && j - L >= 0 && j + L < n) {
                    int sum = 0;
                    int r = i;
                    int c = j;
                    
                    // 3. Trace the perimeter of the rhombus
                    // Slide down-right
                    for (int k = 0; k < L; k++) sum += grid[r++][c++];
                    // Slide down-left
                    for (int k = 0; k < L; k++) sum += grid[r++][c--];
                    // Slide up-left
                    for (int k = 0; k < L; k++) sum += grid[r--][c--];
                    // Slide up-right
                    for (int k = 0; k < L; k++) sum += grid[r--][c++];
                    
                    // Throw the completed sum into our automated tracker
                    topThree.add(sum);
                    if (topThree.size() > 3) topThree.pollFirst();
                    
                    L++; // Grow the rhombus for the next loop
                }
            }
        }
        
        // 4. The problem wants a descending array, so we unpack the TreeSet backwards
        int[] result = new int[topThree.size()];
        int index = topThree.size() - 1;
        for (int sum : topThree) {
            result[index--] = sum;
        }
        
        return result;
    }
}