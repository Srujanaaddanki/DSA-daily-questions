class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String s2 = s + s; // The doubled string trick!
        
        int minFlips = Integer.MAX_VALUE;
        int countA = 0; // Mistakes compared to Pattern A: 010101...
        int countB = 0; // Mistakes compared to Pattern B: 101010...
        
        for (int i = 0; i < s2.length(); i++) {
            // 1. What SHOULD the characters be at this index?
            char expectedA = (i % 2 == 0) ? '0' : '1';
            char expectedB = (i % 2 == 0) ? '1' : '0';
            
            // 2. Add mistakes for the new character entering our window
            if (s2.charAt(i) != expectedA) countA++;
            if (s2.charAt(i) != expectedB) countB++;
            
            // 3. Remove mistakes for the old character that is falling out of our window
            // (We only do this once our window has grown past size n)
            if (i >= n) {
                int leftIndex = i - n; // The index of the character falling off
                char leftExpectedA = (leftIndex % 2 == 0) ? '0' : '1';
                char leftExpectedB = (leftIndex % 2 == 0) ? '1' : '0';
                
                if (s2.charAt(leftIndex) != leftExpectedA) countA--;
                if (s2.charAt(leftIndex) != leftExpectedB) countB--;
            }
            
            // 4. Once our window is exactly size n, record the minimum!
            if (i >= n - 1) {
                minFlips = Math.min(minFlips, Math.min(countA, countB));
            }
        }
        
        return minFlips;
    }
}