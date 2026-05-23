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
    class Result {
        int height;
        TreeNode node;
        Result(int h, TreeNode n) {
            height = h;
            node = n;
        }
    }

    private Result dfs(TreeNode node) {
        if (node == null) return new Result(0, null);
        
        Result left = dfs(node.left);
        Result right = dfs(node.right);
        
        if (left.height > right.height) {
            return new Result(left.height + 1, left.node);
        } else if (right.height > left.height) {
            return new Result(right.height + 1, right.node);
        } else {
            return new Result(left.height + 1, node);
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
}