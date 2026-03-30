class Solution {
    public boolean checkStrings(String s1, String s2) {
        // Two frequency maps for the 26 lowercase English letters
        int[] evenCount = new int[26];
        int[] oddCount = new int[26];
        
        int n = s1.length();
        
        // Step 1: Count the frequencies in a single pass
        for (int i = 0; i < n; i++) {
            char char1 = s1.charAt(i);
            char char2 = s2.charAt(i);
            
            if (i % 2 == 0) {
                // It's an Even index
                evenCount[char1 - 'a']++; // Add s1's letter
                evenCount[char2 - 'a']--; // Subtract s2's letter
            } else {
                // It's an Odd index
                oddCount[char1 - 'a']++;  // Add s1's letter
                oddCount[char2 - 'a']--;  // Subtract s2's letter
            }
        }
        
        // Step 2: Check if everything perfectly cancelled out to zero
        for (int i = 0; i < 26; i++) {
            if (evenCount[i] != 0 || oddCount[i] != 0) {
                // If any letter has a leftover count, it's impossible!
                return false; 
            }
        }
        
        return true;
    }
}