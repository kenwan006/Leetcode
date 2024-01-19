class Solution {
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] e : edges) {
            if (uf.union(e[0], e[1])) return false;
        }
        if (uf.n > 1) return false; //multiple trees
        
        return true;
    }
}

class UF{
    int n;
    int[] parent;
    public UF(int n) {
        this.n = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    
    public boolean union(int p, int q) {
        int rootP = find(p), rootQ = find(q);
        if (rootP == rootQ) return true;
        parent[rootQ] = rootP;
        n--;
        return false;
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}