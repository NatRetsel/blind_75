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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*
            Input: root of trees p and q
            Output: boolean true if trees p and q are the same, false otherwise

            The same: structurally identical and nodes have the same value

            Strategy
            1.) DFS with stack
                - begin with two stack holding root node p and q
                - while both stacks are not empty
                    - pop from both stack
                    - if both nodes are not null
                        - if both nodes have different values, return false
                        - else it means both nodes have the same values
                            - add respective left and right child into respective stack
            
            2.) Recursive DFS
                - Recursive call terminating condition
                    - both nodes are different
                        - both not null and values differ
                        - return false
                    - reached null for either tree
                        - if both are null return true
                        - else return false
                    - recursively compare left subtree
                    - recursively compare right subtree
                    - return left && right
        */  
        if (p != null && q != null) {
            if (p.val != q.val) return false;
        } else if (p == null && q ==null) {
            return true;
        } else {
            return false;
        }

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;

        
    }
}