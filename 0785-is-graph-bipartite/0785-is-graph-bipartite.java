class Solution {
    public boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        int[] vis = new int[nodes]; // All initialized to 0 (unvisited) automatically

        // Step 1: Handle disconnected components
        // A graph can have separate isolated clusters. We loop through all nodes
        // to make sure every single cluster gets checked.
        for (int v = 0; v < nodes; v++) {
            if (vis[v] == 0) { // If this node hasn't been colored yet...
                // Start a DFS coloring chain. We assign it 'Color 1' to begin.
                if (!checkBipartite(v, 1, vis, graph)) {
                    return false; // If a clash is found anywhere, return false immediately
                }
            }
        }
        return true; // If we colored everything successfully with no clashes
    }

    // Step 2: The DFS Coloring Engine
    private boolean checkBipartite(int src, int color, int[] vis, int[][] graph) {
        // Paint the current node with the assigned color
        vis[src] = color;

        // Step 3: Explore all neighbors of the current node
        for (int neighborNode : graph[src]) {
            
            // Case A: The neighbor has NOT been colored yet
            if (vis[neighborNode] == 0) {
                // Determine the opposite color for the neighbor
                int nextColor = (color == 1 ? 2 : 1);

                // Dive deep recursively. If the neighbor's path fails, pass the failure up!
                if (checkBipartite(neighborNode, nextColor, vis, graph) == false) {
                    return false;
                }
            } 
            // Case B: The neighbor is ALREADY colored
            // Check if the neighbor's color is the exact same as our current color.
            else if (vis[src] == vis[neighborNode]) {
                return false; // Clash found! Two adjacent nodes have the same color.
            }
        }

        return true; // This subtree is safely colored
    }
}