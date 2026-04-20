class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;
        
        // Sweep 1: Anchor the first house (index 0)
        // Walk backwards from the end to find the furthest different color
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                maxDist = Math.max(maxDist, i); // Distance is just i - 0
                break; // Stop immediately, this is the furthest possible match for index 0!
            }
        }
        
        // Sweep 2: Anchor the last house (index n - 1)
        // Walk forwards from the start to find the furthest different color
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                maxDist = Math.max(maxDist, (n - 1) - i); // Distance is the end minus current index
                break; // Stop immediately, this is the furthest possible match for index n - 1!
            }
        }
        
        return maxDist;
    }
}