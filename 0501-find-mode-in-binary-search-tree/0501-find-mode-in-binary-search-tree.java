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
    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;
    
    public int[] findMode(TreeNode root) {
        traverse(root);
        List<Integer> res = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount) res.add(key);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = res.get(i);
        return ans;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        maxCount = Math.max(maxCount, map.get(root.val)); //update maxCount
        
        traverse(root.right);
    }
}
//Time: O(n); Space: O(n)
