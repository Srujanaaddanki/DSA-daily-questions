class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int countA = 0;      
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if ((ch - '0') != i % 2) { 
                countA++;
            }
        }
        return Math.min(countA, n - countA);
    }
}