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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean dir = true; // dir - left to right
        
        //bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr;
                if (dir) {
                    curr = queue.remove();
                    if (curr.left != null) queue.add(curr.left); //add left, then add right
                    if (curr.right != null) queue.add(curr.right);
                } else {
                    curr = queue.removeLast();
                    if (curr.right != null) queue.addFirst(curr.right); //add right, then add left
                    if (curr.left != null) queue.addFirst(curr.left);
                }
                currLevel.add(curr.val);
            }
            dir = !dir; //change direction
            res.add(currLevel);
        }
        return res;
    }
}
//Time: O(n); Space: O(n)
