import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0; // Already at the destination index!

        // Step 1: Map each unique value to all the indices where it appears
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(arr[i], new ArrayList<>());
            graph.get(arr[i]).add(i);
        }

        // Step 2: Setup standard Breadth-First Search variables
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        queue.offer(0);
        visited[0] = true;
        int steps = 0;

        // Step 3: Layer-by-layer BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process all reachable nodes at the current step level
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                // Goal check: Did we land on the last index?
                if (curr == n - 1) {
                    return steps;
                }

                // Move 1: Step Right (i + 1)
                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }

                // Move 2: Step Left (i - 1)
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }

                // Move 3: Teleport to any matching values
                if (graph.containsKey(arr[curr])) {
                    for (int nextIdx : graph.get(arr[curr])) {
                        if (!visited[nextIdx]) {
                            visited[nextIdx] = true;
                            queue.offer(nextIdx);
                        }
                    }
                    // CRITICAL TLE FIX: Erase the entry from the map right away 
                    // so no future node wastes time looping through these indices again!
                    graph.remove(arr[curr]);
                }
            }
            // Move on to the next layer of steps
            steps++;
        }

        return -1;
    }
}