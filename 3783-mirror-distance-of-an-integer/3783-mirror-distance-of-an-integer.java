class Solution {
    public int mirrorDistance(int n) {
        int original = n;
        int reversed = 0;
        
        // Build the reversed number purely using math
        while (n > 0) {
            int digit = n % 10;
            reversed = (reversed * 10) + digit;
            n /= 10; // Remove the processed digit
        }
        
        // The problem asks for the absolute distance
        return Math.abs(original - reversed);
    }
}












