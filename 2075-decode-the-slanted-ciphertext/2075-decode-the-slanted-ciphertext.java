class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        
        StringBuilder sb = new StringBuilder();
        
        // Step 1: Iterate through every possible starting column on the top row
        for (int c = 0; c < cols; c++) {
            
            // Step 2: Walk diagonally down-right
            for (int r = 0; r < rows; r++) {
                int currCol = c + r;
                
                // If our diagonal falls off the right side of the grid, stop!
                if (currCol >= cols) {
                    break;
                }
                
                // Step 3: Convert 2D coordinates to the 1D string index
                int index = (r * cols) + currCol;
                sb.append(encodedText.charAt(index));
            }
        }
        
        // Step 4: Remove trailing spaces
        // We start from the back of the StringBuilder and delete until we hit a character
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb.toString();
    }
}