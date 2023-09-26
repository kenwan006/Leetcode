class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new LinkedList<>();
        path = new LinkedList<>();
        path.add(0);
        dfs(0, graph.length - 1, graph);
        return res;
    }
    
    private void dfs(int u, int dst, int[][] graph) {
        if (u == dst) {
            res.add(new LinkedList(path));
            return;
        }
        
        for (int v : graph[u]) {
            path.add(v);
            dfs(v, dst, graph);
            path.removeLast();
        }
    }
}