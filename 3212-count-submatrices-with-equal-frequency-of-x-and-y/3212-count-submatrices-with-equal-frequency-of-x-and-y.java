class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        // Extra size [m+1][n+1] banaya taaki Array Index Out Of Bounds error na aaye
        int[][] xCount = new int[m + 1][n + 1];
        int[][] yCount = new int[m + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                // Check karte hain ki current cell mein kya hai
                int isX = (grid[i][j] == 'X') ? 1 : 0;
                int isY = (grid[i][j] == 'Y') ? 1 : 0;
                
                // 2D Prefix Sum Formula (Exact same logic as LeetCode 3070!)
                xCount[i + 1][j + 1] = isX + xCount[i][j + 1] + xCount[i + 1][j] - xCount[i][j];
                yCount[i + 1][j + 1] = isY + yCount[i][j + 1] + yCount[i + 1][j] - yCount[i][j];
                
                // Condition: X aur Y ki ginti barabar ho, aur kam se kam ek X hona zaroori hai
                if (xCount[i + 1][j + 1] == yCount[i + 1][j + 1] && xCount[i + 1][j + 1] > 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}