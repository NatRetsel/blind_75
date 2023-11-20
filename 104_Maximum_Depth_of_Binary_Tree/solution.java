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
    public int maxDepth(TreeNode root) {
        /*
            Input: root of binary tree
            Output: integer the tree's maximum depth

            Strategy
            1.) BFS with queue
                - initialize a queue to hold TreeNode
                - Begin by pushing root into queue
                - while queue is not empty
                    - empty the queue
                    - if in any of the nodes in the queue are valid nodes, mark a boolean to increment level by 1
                    - if there are valid nodes, push children into the queue

            2.) DFS with stack
                - stack holds (TreeNode, level)
                - With each pop, shortlist the max level
                - with each valid children, push (TreeNode.left/right, level+1)

            3.) DFS recursive
                - Terminating condition
                    - node is null
                        - return 0
                - explore left subtree
                    - left = maxDepth(root.left) + 1;
                - explore right subtree
                    - right = maxDepth(root.right) + 1;
                - return max(left, right);
        */
        if (root == null) return 0;
        return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
    }
}