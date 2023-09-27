class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return dfs(source, destination, new boolean[n], graph);
    }
    
    //dfs - starting from node u, check if we can reach dst
    private boolean dfs(int u, int dst, boolean[] visited, List<List<Integer>> graph) {
        if (u == dst) return true;
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v] && dfs(v, dst, visited, graph)) return true;
        }
        return false;
    }
}