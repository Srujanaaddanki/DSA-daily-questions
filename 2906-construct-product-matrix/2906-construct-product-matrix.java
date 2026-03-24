class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] p = new int[n][m];
        int MOD = 12345;
        
        // Pass 1: Prefix Products (Top-Left to Bottom-Right)
        long pref = 1; // Use long to prevent overflow before applying modulo
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Drop the product of everything BEFORE this cell into the answer
                p[i][j] = (int) pref;
                // Update the running product with the current cell for the next iterations
                pref = (pref * grid[i][j]) % MOD;
            }
        }
        
        // Pass 2: Suffix Products (Bottom-Right to Top-Left)
        long suff = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                // Multiply the existing Prefix product by the product of everything AFTER it
                p[i][j] = (int) ((p[i][j] * suff) % MOD);
                // Update the running product from the back
                suff = (suff * grid[i][j]) % MOD;
            }
        }
        
        return p;
    }
}