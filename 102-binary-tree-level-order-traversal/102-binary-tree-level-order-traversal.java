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
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if(root == null) return result;
        
        queue1.add(root);
        while(!queue1.isEmpty()) { 
            TreeNode node = queue1.poll();
            arr.add(node.val);
            if(node.left != null) queue2.add(node.left);
            if(node.right != null) queue2.add(node.right);
            if(queue1.isEmpty()) {
                result.add(arr);
                queue1 = queue2;
                queue2 = new LinkedList<>();
                arr = new ArrayList<>();
            }
        }
    return result;
    }
}