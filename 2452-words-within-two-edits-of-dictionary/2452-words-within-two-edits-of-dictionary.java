import java.util.*;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        
        // Check every query word
        for (String query : queries) {
            
            // Against every dictionary word
            for (String dictWord : dictionary) {
                int diff = 0;
                
                // Compare them character by character
                for (int i = 0; i < query.length(); i++) {
                    if (query.charAt(i) != dictWord.charAt(i)) {
                        diff++;
                    }
                    
                    // Early Exit 1: The moment we exceed 2 edits, stop checking these two words
                    if (diff > 2) {
                        break; 
                    }
                }
                
                // Early Exit 2: If we survived the check with 2 or fewer edits, it's a valid query!
                if (diff <= 2) {
                    result.add(query);
                    break; // Stop checking this query against the rest of the dictionary
                }
            }
        }
        
        return result;
    }
}