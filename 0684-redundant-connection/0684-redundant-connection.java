class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UF uf = new UF(n);
        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) return edge;
        }
        return null;
    }
    
    class UF {
        int[] parent;
        public UF(int n) {
            parent = new int[n + 1]; //0, 1, 2..n
            for (int i = 0; i <= n; i++) parent[i] = i;
        }
        private boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return true;
            parent[rootP] = rootQ;
            return false;
        }
        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}