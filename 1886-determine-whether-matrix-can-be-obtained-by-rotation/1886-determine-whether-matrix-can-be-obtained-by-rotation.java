import java.util.Arrays;

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        // A matrix only has 4 possible rotations (0, 90, 180, 270 degrees)
        for (int i = 0; i < 4; i++) {
            
            // 1. Check if they currently match
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
            
            // 2. If not, rotate the matrix by 90 degrees clockwise and try again
            rotate(mat);
        }
        
        // If we rotated 4 times and never found a match, it's impossible.
        return false;
    }
    
    // --- Helper Method: The classic 90-degree rotation trick ---
    private void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Step 1: Transpose (Swap rows and columns)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse every row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                
                left++;
                right--;
            }
        }
    }
}