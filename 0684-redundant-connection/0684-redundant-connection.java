class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length + 1);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (uf.find(u) == uf.find(v)) return edge;
            uf.union(u, v);
        }
        return new int[]{-1, -1};
    }
    
    class UF {
        int[] parent;
        int[] size;
        
        public UF(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            
            if (size[rootP] > size[rootQ]) {
                size[rootP] += size[rootQ];
                parent[rootQ] = rootP;
            } else {
                size[rootQ] += size[rootP];
                parent[rootP] = rootQ;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
//Time: O(v + e); Space: O(v)

