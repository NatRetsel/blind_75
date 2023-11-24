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
    public boolean recursion(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        return recursion(root.left, min, root.val) && recursion(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        /*
            Input: root of a binary tree
            Output: boolean true if it is a valid bst, false otherwise

            valid bst:
                - left substree contains nodes with value less than root
                - right substree contains node with value greater than root
                - in each subtree the rule also holds
            
            Strategy
            - a tree is a valid bst if the subtrees are all valid bst
            - pass values to be compared against down the dfs, a min and a max
            - at root, min and max equals zero
            - down left subtree, max = root.val, min = null
            - down right subtree, min = root.val, max = null
        
        */
        return recursion(root, null, null);
    }
}