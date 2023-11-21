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
    public boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null && root == null) {
            return true;
        }else if (subRoot != null && root != null) {
            if (subRoot.val != root.val) {
                return false;
            }
        }else{
            return false;
        }
        boolean left = sameTree(root.left, subRoot.left);
        boolean right = sameTree(root.right, subRoot.right);
        return left && right;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        /*
            Input: root of binary trees root and subRoot
            Output: Boolean true if subRoot exist in root

            Strategy
            1.) implement the solution for same tree as a separate function to be called when we find a node in root whose
            value equals the root node's value in subRoot.
        */

        if (root == null) return false;
        boolean potential = false;
        if (root.val == subRoot.val) {
            potential = sameTree(root, subRoot);
        }
        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);
        return left || right || potential;
    }
}