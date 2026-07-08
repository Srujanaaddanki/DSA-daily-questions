/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(p.val < root.val && q.val < root.val){
                root= root.left;
            }else if (p.val > root.val && q.val > root.val){
                root = root.right;
            }else{
                return root;
            }
        }
        return null;
    }
}












// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if (root.val == p.val || root.val == q.val) return root;
//         if (root.val < p.val && q.val < root.val) return root;
//         if (root.val < q.val && p.val < root.val) return root;

//         if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
         
//         return lowestCommonAncestor(root.left, p, q);
//     }
// }