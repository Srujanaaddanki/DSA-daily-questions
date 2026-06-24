class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start our recursive search with an empty "current" subset at index 0
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Every single step of our decision tree is a valid subset, so copy and add it!
        result.add(new ArrayList<>(currentSubset));
        
        // Loop through the remaining choices available to us
        for (int i = start; i < nums.length; i++) {
            // 1. Take the element (Make Choice)
            currentSubset.add(nums[i]);
            
            // 2. Move deeper into the tree (Explore future elements)
            // We pass 'i + 1' so we don't accidentally reuse the exact same element twice
            backtrack(result, currentSubset, nums, i + 1);
            
            // 3. Remove the element (Undo Choice / Backtrack)
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}