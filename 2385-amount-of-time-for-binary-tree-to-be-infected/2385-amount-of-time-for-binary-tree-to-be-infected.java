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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        dfs(root, null, graph);
        
        //bfs
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int next : graph.get(curr)) {
                    if (visited.contains(next)) continue;
                    queue.offer(next);
                    visited.add(next);
                }
            }
            time++;
        }
        return time - 1;
    }
    
    private void dfs(TreeNode root, TreeNode parent, Map<Integer, Set<Integer>> graph) {
        if (root == null) return;
        
        if (!graph.containsKey(root.val)) graph.put(root.val, new HashSet<>());
        
        Set<Integer> adj = graph.get(root.val);
        
        if (parent != null) adj.add(parent.val);
        
        if (root.left != null) adj.add(root.left.val);
        
        if (root.right != null) adj.add(root.right.val);
        
        dfs(root.left, root, graph);
        dfs(root.right, root, graph);
    }
}