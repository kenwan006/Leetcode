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

/** Recursive in-order traversal */
/*
class Solution {
    int res = -1; 
    int rank = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
    
    private void traverse(TreeNode root, int k) {
        if (root == null) return;
        
        traverse(root.left, k);
        
        rank++;
        if (rank == k){
            res = root.val;
            return;
        }
        
        traverse(root.right, k); 
    }
}
*/

/** Iterative in-order traversal */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode p = root; // define a pointer to iterate over all nodes
        
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p); // keep pushing the left until reach the bottom (unvisited smallest)
                p = p.left; 
            } else {
                TreeNode node = stack.pop(); // the most smallest root 
                if (++count == k) return node.val;
                p = node.right;
            }
        }
        return -1;
    }
}


