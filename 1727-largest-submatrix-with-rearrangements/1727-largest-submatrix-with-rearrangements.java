import java.util.*;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        // Step 1: Build the skyline (Count consecutive 1s from top to bottom)
        // We start at row 1 because row 0 already has its accurate heights!
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the current cell is a 1, stack it on top of the building above it
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        // Step 2: Sort each row and calculate the maximum area
        for (int i = 0; i < m; i++) {
            // Sort the building heights (tallest buildings move to the end)
            Arrays.sort(matrix[i]);
            
            // Start from the end (tallest) and walk backwards to the shortest
            for (int j = n - 1; j >= 0; j--) {
                int height = matrix[i][j];
                
                // The width is how many buildings we have looked at so far
                int width = n - j; 
                
                // Area = height * width
                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }
}