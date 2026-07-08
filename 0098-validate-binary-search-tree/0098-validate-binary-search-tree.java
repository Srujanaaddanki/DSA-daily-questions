/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    // We initialize 'prev' outside the method so it persists across recursive visits.
    // Since node values can go up to the Integer limits, we start at the absolute minimum long value.
    long prev = Long.MIN_VALUE; 
    public boolean isValidBST(TreeNode root) {
        // Base case: An empty tree branch is valid
        if (root == null) {
            return true;
        }
        // 1. Visit the entire Left subtree first
        if (!isValidBST(root.left)) {
            return false;
        }
        // 2. Process the Current node (Your "prev <= curr" logic check)
        if (root.val <= prev) {
            return false; // Broken! The sequence is not increasing.
        }
        prev = root.val; // Update 'prev' to be this current value before moving on

        // 3. Visit the entire Right subtree last
        return isValidBST(root.right);
    }
}