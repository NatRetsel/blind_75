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
    int interPathMax = Integer.MIN_VALUE;
    int singleNodeMax = Integer.MIN_VALUE;
    public int recursion(TreeNode root) {
        if (root == null) return 0;
        int left = recursion(root.left);
        int right = recursion(root.right);
        int path = Math.max(Math.max(left + root.val, root.val), right + root.val);
        singleNodeMax = Math.max(singleNodeMax, root.val);
        interPathMax = Math.max(Math.max(interPathMax, left + right + root.val),path);
        return path;  
    }
    public int maxPathSum(TreeNode root) {
        /*
            Input: root of binary tree
            Output: integer the maximum path sum

            Path: sequence of nodes where an edge is present between a pair
            A node itself can also be a path

            Path sum: sum of node values in the path
            - In a single subtree of 3 nodes like in example 1: 
                path 0: the individual nodes themselves
                path 1: 2,1,3
                    - sum of path = left node + right node + parent
                path 2: 2,1 
                path 3: 1,3
            - For example 2, 
                - path 0: individual nodes in the tree
                - path 1: 15, 20, 7 = 42
                - path 2: 15, 20
                - path 3: 20, 7
                - path 4: 9, -10
                - path 5: -10, 20
                - path 6: -10, 20, 15
                - path 7: -10, 20, 7
                - path 8: 9, -10, 20, 15
                - path 9: 9, -10, 20, 7
                - path 10: 9, -10, 20
            
            To find maximum path sum
            1.) Compute all paths independently and shortlist maximum (gets exponential)
            2.) Is there an optimal way of selecting or counting?
                -  Considering a dfs approach
                    - upon returning from a child, we have
                        - from left and right subtree
                            - value of the child
                            - max value of a path the child is in
                            - we can select for the max between both
                    - we can establish a path between a child and parent
                    - we can establish a path between 2 child and parent, foregoing valid paths above
                        - shortlist with a global maybe
                    - a single node in the mdidle of the tree can also be the max, shortlist with a global     

        */
        return Math.max(Math.max(recursion(root), interPathMax), singleNodeMax);
    }
}