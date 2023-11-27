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
    public int kthSmallest(TreeNode root, int k) {
        /*
            Input: root of a bst root, integer k
            Output: integer the value of the kth smallest node value

            Strategy
            - Inorder traversal
                - In a bst, inorder traversal guarantees traversal in ascending order
            - iterative inorder traversal
                - have a variable tracking k
                - pass in node and a boolean representing seen
                    - if not seen, mark as seen, add back into stack and append left child
                    - if seen, note value*, append right child
                - note value*
                    - if value == k return node.val
                    - else ++value;

            Stack<Pair<TreeNode,Integer>> stack = new Stack<>();
            int n = 0;
            int res = 0;
            Pair<TreeNode, Integer> node = new Pair(root, 0);
            stack.push(node);
            while(!stack.isEmpty()) {
                node = stack.pop();
                if(node.getValue() == 0) {
                    node = new Pair(node.getKey(), 1);
                    stack.push(node);
                    if(node.getKey().left != null) {
                        stack.push(new Pair(node.getKey().left, 0));
                    }
                }else{
                    ++n;
                    if (n==k) {
                        res = node.getKey().val;
                        break;
                    }
                    if(node.getKey().right != null) {
                        stack.push(new Pair(node.getKey().right, 0));
                    }
                }
            }
            return res;

            optimise
            - instead of a pair, we use two references, one on the current node and another if the stack is not
            empty
            - begin with an empty stack with curr referencing the root
            - since curr is not null, we append curr to stack for subsequent right subtree traversal
                - replace curr with curr.left - once it reaches null, we arrived at leaf, parent is in stack
            - if curr is null, means stack is not empty
                - curr = stack.pop
                - if --k == 1 return curr.val
                - curr = curr.right
        */
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr!= null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                if (--k == 0) return curr.val;
                curr = curr.right;
            }
        }
        return curr.val;
    }
}