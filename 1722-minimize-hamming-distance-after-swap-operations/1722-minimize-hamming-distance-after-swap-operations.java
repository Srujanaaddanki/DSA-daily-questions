import java.util.*;

class Solution {
    // Array to track the "root" or "boss" of each index's connected component
    private int[] parent;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        parent = new int[n];
        
        // Step 1: Initially, every index is its own boss
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        // Step 2: Group connected indices using the swaps
        for (int[] swap : allowedSwaps) {
            union(swap[0], swap[1]);
        }
        
        // Step 3: Build the "Available Numbers" pools
        // Map<RootIndex, Map<Number, Frequency>>
        Map<Integer, Map<Integer, Integer>> pools = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int root = find(i);
            pools.putIfAbsent(root, new HashMap<>());
            
            // Add the current source number to its respective pool
            Map<Integer, Integer> store = pools.get(root);
            store.put(source[i], store.getOrDefault(source[i], 0) + 1);
        }
        
        // Step 4: Calculate the Hamming Distance
        int hammingDistance = 0;
        
        for (int i = 0; i < n; i++) {
            int root = find(i);
            Map<Integer, Integer> store = pools.get(root);
            int requiredNum = target[i];
            
            // If the required number is in the pool, use it!
            if (store.getOrDefault(requiredNum, 0) > 0) {
                store.put(requiredNum, store.get(requiredNum) - 1);
            } else {
                // The number isn't in the pool. It's a mismatch.
                hammingDistance++;
            }
        }
        
        return hammingDistance;
    }
    
    // --- Union-Find Helper Methods ---
    
    // Finds the root of a component (with Path Compression for extreme speed)
    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        // Flatten the tree by making the node point directly to the ultimate root
        return parent[i] = find(parent[i]); 
    }
    
    // Merges two components together
    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        
        if (rootI != rootJ) {
            parent[rootI] = rootJ; // Make one root point to the other
        }
    }
}