import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Step 1: Sort robots and factories by their positions on the X-axis
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Step 2: Flatten the factory capacities into individual slots
        List<Integer> factoryPositions = new ArrayList<>();
        for (int[] f : factory) {
            int position = f[0];
            int capacity = f[1];
            for (int i = 0; i < capacity; i++) {
                factoryPositions.add(position);
            }
        }
        
        int n = robot.size();
        int m = factoryPositions.size();
        
        // DP array to store the next row's results (i + 1)
        long[] next = new long[m + 1];
        
        // Step 3: Process from the last robot down to the first
        for (int i = n - 1; i >= 0; i--) {
            // current row for robot i
            long[] curr = new long[m + 1];
            
            // Base case for this row: if we run out of factory slots but still have robots
            curr[m] = (long) 1e18; 
            
            for (int j = m - 1; j >= 0; j--) {
                // Choice 1: Assign robot i to factory slot j
                long assign = Math.abs((long) robot.get(i) - factoryPositions.get(j)) + next[j + 1];
                
                // Choice 2: Skip factory slot j
                long skip = curr[j + 1];
                
                // Take the optimal choice
                curr[j] = Math.min(assign, skip);
            }
            // Move current row to next for the upcoming iteration
            next = curr;
        }
        
        return next[0];
    }
}