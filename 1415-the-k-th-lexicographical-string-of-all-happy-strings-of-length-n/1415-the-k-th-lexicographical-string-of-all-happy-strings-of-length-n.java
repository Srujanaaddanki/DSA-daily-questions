class Solution {
    // We make these class-level variables so our recursive function can easily see them
    int count = 0;
    String result = "";

    public String getHappyString(int n, int k) {
        // Start the recursive process with an empty string
        backtrack(n, k, new StringBuilder());
        return result;
    }

    private void backtrack(int n, int k, StringBuilder current) {
        // 1. EARLY EXIT: If we already found our answer, stop doing math and go home!
        if (!result.isEmpty()) {
            return;
        }

        // 2. BASE CASE: We successfully built a string of length 'n'
        if (current.length() == n) {
            count++; // We found a valid happy string!
            
            if (count == k) { // Is it the exact one we are looking for?
                result = current.toString(); // Save it!
            }
            return; // Go back up the tree
        }

        // 3. RECURSIVE STEP: Try adding 'a', then 'b', then 'c'
        for (char c = 'a'; c <= 'c'; c++) {
            
            // The "Happy" Rule: If the string isn't empty, check the last letter. 
            // If it matches our current letter, skip it!
            if (current.length() > 0 && current.charAt(current.length() - 1) == c) {
                continue; 
            }

            // --- THE BACKTRACKING BLUEPRINT ---
            
            // A. CHOOSE: Add the letter
            current.append(c);
            
            // B. EXPLORE: Move to the next spot in the string
            backtrack(n, k, current);
            
            // C. UN-CHOOSE (BACKTRACK): Delete the letter so the loop can try the next one!
            current.deleteCharAt(current.length() - 1);
        }
    }
}