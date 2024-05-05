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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        res.add(root.val);
        leftBound(res, root.left);
        leaves(res, root.left);
        leaves(res, root.right);
        rightBound(res, root.right);
        
        return res;
    }
    
    private void leftBound(List<Integer> res, TreeNode root) {
        if (root == null || isLeaf(root)) return;
        
        res.add(root.val);
        if (root.left != null) {
            leftBound(res, root.left);
        } else {
            leftBound(res, root.right);
        }
    }
    
    private void rightBound(List<Integer> res, TreeNode root) {
        if (root == null || isLeaf(root)) return;
        if (root.right != null) {
            rightBound(res, root.right);
        } else {
            rightBound(res, root.left);
        }
        res.add(root.val);
    }
    
    private void leaves(List<Integer> res, TreeNode root) {
        if (root == null) return;
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        leaves(res, root.left);
        leaves(res, root.right);
    }
    
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}