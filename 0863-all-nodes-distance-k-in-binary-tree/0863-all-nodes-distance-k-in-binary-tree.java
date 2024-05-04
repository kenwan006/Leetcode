/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, List<Integer>> graph;
    Set<Integer> visited;
    List<Integer> res;
        
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //build graph
        graph = new HashMap<>();
        build(root, null, graph);
        
        //dfs - find the node with distance k from the target node
        res = new ArrayList<>();
        visited = new HashSet<>();
        dfs(target.val, 0, k);
        return res;
    }
    
    private void dfs(int src, int dist, int k) {
        if (visited.contains(src)) return;
        visited.add(src);
        
        if (dist == k) {
            res.add(src);
            return;
        }
        
        for (int next : graph.get(src)) dfs(next, dist + 1, k);
    }
    
    
    
    //build a undirected graph
    private void build(TreeNode root, TreeNode parent, Map<Integer, List<Integer>> graph) {
        if (root == null) return;
        graph.put(root.val, new ArrayList<>());
        
        if (parent != null) {
            graph.get(root.val).add(parent.val);
            graph.get(parent.val).add(root.val);
        }

        build(root.left, root, graph);
        build(root.right, root, graph);
    }
}

//Time: O(v); Space: O(v + e)