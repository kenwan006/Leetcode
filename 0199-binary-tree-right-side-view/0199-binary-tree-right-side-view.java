/*** Approach 1: BFS
/*** Approach 2: DFS
*/
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

/** BFS
* use a queue to store all nodes for each level, the node from right side view is the last item in the queue
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) res.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        
        return res;
    }
} 


/** DFS
* Similar to dfs preorder traversal (root -> left -> right), the difference is for this problem the travsering order is root -> right -> left
* We will only take the right most node from each level and put it to the result, which means depth == result.size().
*/
/*
class Solution {
    List<Integer> res = new LinkedList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    
    public void dfs(TreeNode node, int depth) {
        if (node == null) return;
        if(res.size() == depth) res.add(node.val);
        
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }
}
*/
