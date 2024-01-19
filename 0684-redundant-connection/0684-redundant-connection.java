class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UF uf = new UF(n);
        for (int[] e : edges) {
            if (uf.union(e[0], e[1])) return e;
        }
        return null;
    }
    
}

class UF {
    int n;
    int[] parent;
    
    public UF(int n) {
        this.n = n;
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;
    }
    
    
    public boolean union(int p, int q) {
        int rootP = find(p), rootQ = find(q);
        if (rootP == rootQ) return true;
        parent[rootQ] = rootP;
        return false;
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}