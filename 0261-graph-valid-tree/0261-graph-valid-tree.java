class Solution {
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (!uf.union(u, v)) return false;
        }
        return uf.count == 1;  //to avoid forester when count > 1
    }
    
    class UF {
        int[] parent;
        int[] size;
        int count;
        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public boolean union(int p, int q){
            int rootP = find(p), rootQ = find(q);
            if (rootP == rootQ) return false; //p and q already connected
            
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
            return true;
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