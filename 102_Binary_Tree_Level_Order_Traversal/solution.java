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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*
            Input: root of a binary tree
            Ouptut: list of list of integer the nodes in each level from l to r

            Strategy
            1.) BFS variation
                - ArrayList to hold nodes in every layer
                - while arraylist is not empty
                    - create an empty arraylist to hold children
                    - for every node in arraylist, fill another arraylist with the node's children
                    - add the initial array list into the results array
                    - replace reference of the initial array list to the arraylist holding the
                    node's children.
        */
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            List<TreeNode> layer = new ArrayList<TreeNode>();
            layer.add(root);
            while(!layer.isEmpty()) {
                List<TreeNode>children = new ArrayList<TreeNode>();
                List<Integer>to_res = new ArrayList<Integer>();
                for (TreeNode tn: layer) {
                    if(tn.left != null) children.add(tn.left);
                    if(tn.right != null) children.add(tn.right);
                    to_res.add(tn.val);
                }
                res.add(to_res);
                layer = children;
            }
        }
        return res;
    }
}