class Solution {
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (o1, o2) -> o1[2] - o2[2]);
        UF uf = new UF(n + 1); //1-indexed
        int mst = 0;
        int count = 0; //total edges added to the mst
        for (int[] e : connections) {
            int u = e[0], v = e[1], w = e[2];
            if (!uf.union(u, v)) continue; //continue if already connected
            mst += w;
            count++;
        }
        return count == n - 1? mst : -1;
    }
    
    class UF {
        int[] parent;
        public UF (int V) {
            parent = new int[V];
            for (int i = 0; i < V; i++) parent[i] = i;
        }
        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return false;
            parent[rootP] = rootQ;
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
//Time: O(e * log(e)); Space: O(v)