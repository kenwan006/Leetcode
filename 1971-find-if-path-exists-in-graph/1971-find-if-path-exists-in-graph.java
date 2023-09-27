class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            uf.union(u, v);
        }
        return uf.union(source, destination);
    }
    
    class UF {
        int[] parent;
        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        private boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return true;
            parent[rootP] = rootQ;
            return false;
        }
        private int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}