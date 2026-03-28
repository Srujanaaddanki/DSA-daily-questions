class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];
        char currentChar = 'a';
        
        // --- PHASE 1: Greedy String Construction ---
        for (int i = 0; i < n; i++) {
            // If this index hasn't been assigned a character yet
            if (word[i] == 0) {
                // If we run out of lowercase English letters, it's impossible!
                if (currentChar > 'z') {
                    return ""; 
                }
                
                // Assign the current character to this index
                word[i] = currentChar;
                
                // Find all other indices that MUST share this character
                for (int j = i + 1; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        word[j] = currentChar;
                    }
                }
                // Move to the next letter in the alphabet for the next empty spot
                currentChar++; 
            }
        }
        
        // --- PHASE 2: DP Validation ---
        // We iterate backwards to build the LCP from the ends of the suffixes
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                
                int expectedLCP = 0;
                
                // If the characters match, calculate the expected LCP
                if (word[i] == word[j]) {
                    expectedLCP = 1;
                    // Add the LCP of the remainder of the suffixes (if within bounds)
                    if (i + 1 < n && j + 1 < n) {
                        expectedLCP += lcp[i + 1][j + 1];
                    }
                }
                
                // If our calculated LCP doesn't perfectly match their matrix, return ""
                if (lcp[i][j] != expectedLCP) {
                    return "";
                }
            }
        }
        
        // If it survived the validation, we found our perfect string!
        return new String(word);
    }
}