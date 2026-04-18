import java.util.*;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        // Map to store: (Reversed Value -> Latest Index)
        Map<Integer, Integer> wantedList = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            // 1. Is any previous index waiting for this exact number?
            if (wantedList.containsKey(nums[i])) {
                int previousIndex = wantedList.get(nums[i]);
                minDistance = Math.min(minDistance, i - previousIndex);
            }
            
            // 2. Reverse the current number and add it to the wanted list for future numbers
            int rev = reverse(nums[i]);
            wantedList.put(rev, i);
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
    
    // Helper method to reverse the digits of an integer
    private int reverse(int x) {
        int reversed = 0;
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return reversed;
    }
}