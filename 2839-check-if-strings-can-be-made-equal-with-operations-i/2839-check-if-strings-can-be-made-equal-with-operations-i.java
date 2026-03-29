class Solution {
    public boolean canBeEqual(String s1, String s2) {
        // 1. Check if the Even group matches (Indices 0 and 2)
        // They either match exactly as they are, OR they match if we swap one of them
        boolean evenMatch = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
                            (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));
                            
        // 2. Check if the Odd group matches (Indices 1 and 3)
        boolean oddMatch = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
                           (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));
                           
        // If both the Even group and the Odd group can be made to match, we win!
        return evenMatch && oddMatch;
    }
}