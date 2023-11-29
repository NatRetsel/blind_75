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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
            Input: integer array values of nodes in preorder and inorder traversal
            Output: TreeNode the root of the constructed binary tree.

            preorder traversal: visit head, left then right
            inorder traversal: visit left, head then right

            To construct the binary tree recursively, we pass in array copies
            - for every node in preorder (since we visit the head first),
                - find where it lies in inorder
                    - values to the left of it reside in the left subtree
                    - values to the right of it reside in the right subtree
                - for the same index where node was located in inorder,
                    - values from 1 to index+1 (include index, excl +1) lies in the left subtree
                    - values from index+1 to the end lies in the right subtree
            - terminating condition
                - when either of the array length reaches 0, the previous call created a leaf node,
                    - we return null.
                
        */
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode node = new TreeNode(preorder[0]);
        int idx;
        for (idx = 0; idx < inorder.length; idx++) {
            if (preorder[0] == inorder[idx]) break;
        }
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, idx+1), Arrays.copyOfRange(inorder,0,idx+1));
        node.right = buildTree(Arrays.copyOfRange(preorder, idx+1, preorder.length), Arrays.copyOfRange(inorder, idx+1, inorder.length));
        return node;
    }
}