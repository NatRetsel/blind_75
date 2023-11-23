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
        /*
            Input: root of bst root, nodes p and q
            Output: node the LCA of p and q

            LCA: the LCA between two nodes is the node t that has both p and q as descendants
            LCA can also be either p / q.

            Strategy
            1.) Recognizing BST
                - left child < parent < right child
                - either they lie on the same subtree or different
                    - same subtree
                        - both smaller than root or both greater than root
                        - we move into the respective subtree
                    - diff subtree
                        - one smaller or eq and one greater or eq than root
                        - root is the LCA
        */
        while(root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }else{
                return root;
            }
        }
        return root;
    }
}