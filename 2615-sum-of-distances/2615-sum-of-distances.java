import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        
        // Map to store Number -> List of its naturally sorted indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        
        // Process each group of identical numbers
        for (List<Integer> indices : map.values()) {
            int m = indices.size();
            
            // If there's only 1 occurrence, its distance is 0
            if (m == 1) continue;
            
            // Calculate the total sum of all indices in this group
            long totalSum = 0;
            for (int index : indices) {
                totalSum += index;
            }
            
            long leftSum = 0;
            long rightSum = totalSum;
            
            for (int i = 0; i < m; i++) {
                long currentIndex = indices.get(i);
                
                // Remove the current index from the right side
                rightSum -= currentIndex;
                
                // Calculate distance to all identical numbers on the left
                long elementsOnLeft = i;
                long leftDistance = (elementsOnLeft * currentIndex) - leftSum;
                
                // Calculate distance to all identical numbers on the right
                long elementsOnRight = m - 1 - i;
                long rightDistance = rightSum - (elementsOnRight * currentIndex);
                
                // The total distance is the sum of both sides
                ans[(int) currentIndex] = leftDistance + rightDistance;
                
                // Add the current index to the left side for the next iteration
                leftSum += currentIndex;
            }
        }
        
        return ans;
    }
}