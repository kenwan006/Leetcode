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
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return result;
        
        queue.add(root);
        while(!queue.isEmpty()) {
            int levelNum = queue.size(); // length of each layer
            List<Integer> arr = new ArrayList<>();
            for(int i = 0; i < levelNum; i++) {
                TreeNode node = queue.peek();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                arr.add(node.val);
                queue.remove();
            }
            result.add(arr);
        }
        return result;
        
    }
}