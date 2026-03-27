class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Step 1: Simplify k in case it is larger than the row length
        k = k % n; 
        
        // Step 2: Traverse the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                // Step 3: Check if the current element matches the one 'k' steps away
                // The modulo '% n' naturally handles the "wrap around" to the start of the row
                if (mat[i][j] != mat[i][(j + k) % n]) {
                    return false; // Found a mismatch! They are not similar.
                }
                
            }
        }
        
        // If we survived the whole loop without returning false, it's a perfect match!
        return true;
    }
}