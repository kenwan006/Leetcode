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
    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        traverse(root);
        return balanced(0, list.size() - 1);
    }
    
    //build balanced bst based on the list of nodes
    private TreeNode balanced(int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = balanced(lo, mid - 1);
        root.right = balanced(mid + 1, hi);
        return root;
    }
    
    //in-order travesal to collect each node
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
}