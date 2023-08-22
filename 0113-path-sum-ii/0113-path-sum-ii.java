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
    List<List<Integer>> res;
    LinkedList<Integer> path;
    int sum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        if (root == null) return res;
        path.add(root.val);
        sum += root.val;
        backtrack(root, targetSum);
        return res;
    }
    
    private void backtrack(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null && sum == targetSum) {
            res.add(new LinkedList<>(path));
            return;
        }
        
        int val = 0;
        //left
        if (root.left != null) {
            val = root.left.val;
            sum += val;
            path.add(val);
            backtrack(root.left, targetSum);
            path.removeLast();
            sum -= val;
        }
        
        //right
        if (root.right != null) {
            val = root.right.val;
            sum += val;
            path.add(val);
            backtrack(root.right, targetSum);
            path.removeLast();
            sum -= val;
        }
    }
    
}