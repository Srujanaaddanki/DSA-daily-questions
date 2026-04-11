import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        // Map every unique number to a list of the exact indices where it appears
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Create a new list for the number if it doesn't exist yet
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            // Add the current index to that number's list
            map.get(nums[i]).add(i);
        }
        
        int minDistance = Integer.MAX_VALUE;
        
        // Check the index lists for every unique number we found
        for (List<Integer> indices : map.values()) {
            
            // We need at least 3 occurrences to form a valid triplet
            if (indices.size() >= 3) {
                
                // Check every consecutive triplet in this specific list
                for (int i = 0; i < indices.size() - 2; i++) {
                    int first = indices.get(i);
                    int third = indices.get(i + 2); // The middle index (i + 1) is mathematically irrelevant!
                    
                    // Our simplified math formula
                    int currentDistance = 2 * (third - first);
                    minDistance = Math.min(minDistance, currentDistance);
                }
            }
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}