import java.util.*;

class Solution {
    // 1. Custom class to keep a robot's position and distance permanently bundled
    class Robot {
        int pos;
        int dist;
        Robot(int pos, int dist) {
            this.pos = pos;
            this.dist = dist;
        }
    }

    private Integer[][] memo;
    private Robot[] arr;
    private int[] walls;
    private int n;

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        n = robots.length;
        arr = new Robot[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Robot(robots[i], distance[i]);
        }
        
        // Step 1: Sort robots physically from left to right
        Arrays.sort(arr, (a, b) -> Integer.compare(a.pos, b.pos));
        
        // Step 2: Sort walls so we can use Binary Search to count them instantly
        Arrays.sort(walls);
        this.walls = walls;
        
        // memo[i][j]: max walls from robot 0 to i. 
        // j is the direction robot i+1 fired (0 for Left, 1 for Right)
        memo = new Integer[n][2];
        
        // We start evaluating from the last robot down to the first.
        // We assume a theoretical robot at infinity fired right so it doesn't restrict robot n-1.
        return dfs(n - 1, 1);
    }

    private int dfs(int i, int nextDir) {
        if (i < 0) return 0; // Base case: no more robots
        if (memo[i][nextDir] != null) return memo[i][nextDir];

        // --- OPTION 1: Robot i fires LEFT ---
        int leftReach = arr[i].pos - arr[i].dist;
        if (i > 0) {
            // It gets blocked by the physical body of the robot to its left
            leftReach = Math.max(leftReach, arr[i - 1].pos + 1);
        }
        
        // Count walls in [leftReach, arr[i].pos]
        int countLeft = countWalls(leftReach, arr[i].pos);
        // Move to the next robot, recording that the current robot fired LEFT (0)
        int ansLeft = countLeft + dfs(i - 1, 0);


        // --- OPTION 2: Robot i fires RIGHT ---
        int rightReach = arr[i].pos + arr[i].dist;
        if (i + 1 < n) {
            if (nextDir == 0) {
                // Robot i+1 fired LEFT! To avoid double counting, we stop our count 
                // just before the reach of robot i+1's bullet.
                rightReach = Math.min(rightReach, arr[i + 1].pos - arr[i + 1].dist - 1);
            } else {
                // Robot i+1 fired RIGHT! It just acts as a physical wall blocking us.
                rightReach = Math.min(rightReach, arr[i + 1].pos - 1);
            }
        }
        
        // Ensure we always at least count the wall sitting on our own position (if any)
        rightReach = Math.max(rightReach, arr[i].pos);
        
        // Count walls in [arr[i].pos, rightReach]
        int countRight = countWalls(arr[i].pos, rightReach);
        // Move to the next robot, recording that the current robot fired RIGHT (1)
        int ansRight = countRight + dfs(i - 1, 1);

        // Return the best reality!
        return memo[i][nextDir] = Math.max(ansLeft, ansRight);
    }

    // --- Helper Methods ---

    // Uses Binary Search to instantly count how many walls exist between 'start' and 'end'
    private int countWalls(int start, int end) {
        if (start > end) return 0;
        int l = lowerBound(walls, start);
        int r = lowerBound(walls, end + 1);
        return Math.max(0, r - l);
    }

    // Classic Binary Search implementation to find the insertion index
    private int lowerBound(int[] a, int target) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}