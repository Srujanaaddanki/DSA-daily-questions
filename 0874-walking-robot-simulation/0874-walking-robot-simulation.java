import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // The Compass: North, East, South, West
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0; // Starts facing North (index 0)
        
        int x = 0, y = 0;
        int maxDistSq = 0;
        
        // Hash obstacles as "x,y" strings for O(1) instant lookup
        Set<String> obsSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obsSet.add(obs[0] + "," + obs[1]);
        }
        
        // Process each command
        for (int cmd : commands) {
            if (cmd == -1) { 
                // Turn Right
                dir = (dir + 1) % 4;
            } else if (cmd == -2) { 
                // Turn Left (Add 3 instead of subtracting 1 to avoid Java negative modulo bugs)
                dir = (dir + 3) % 4; 
            } else {
                // Move forward 'cmd' steps
                for (int step = 0; step < cmd; step++) {
                    int nextX = x + dx[dir];
                    int nextY = y + dy[dir];
                    
                    // Check if there is an obstacle in the way
                    if (obsSet.contains(nextX + "," + nextY)) {
                        break; // Stop moving, the robot is stuck!
                    }
                    
                    // It's safe! Take the step.
                    x = nextX;
                    y = nextY;
                    
                    // The problem asks for the max distance at ANY point, so update it every step
                    maxDistSq = Math.max(maxDistSq, x * x + y * y);
                }
            }
        }
        
        return maxDistSq;
    }
}