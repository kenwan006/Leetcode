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
    public TreeNode balanceBST(TreeNode root) {
        //add all nodes to a list in asc order
        List<TreeNode> list = new ArrayList<>();
        traverse(root, list);
        //build a balanced bst
        return balanced(list, 0, list.size() - 1);
    }
    
    //convert a list of TreeNode to a balanced bst
    private TreeNode balanced(List<TreeNode> list, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = list.get(mid);
        root.left = balanced(list, lo, mid - 1);
        root.right = balanced(list, mid + 1, hi);
        return root;
    }
    
    //in order traversal
    private void traverse(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        traverse(root.left, list);
        list.add(root);
        traverse(root.right, list);
    }
}
//Time: O(n); Space: O(n)
