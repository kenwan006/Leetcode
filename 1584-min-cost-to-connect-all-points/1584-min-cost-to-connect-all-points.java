class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, dist});
            }
        }
        Collections.sort(edges, (o1, o2) -> o1[2] - o2[2]);
        
        UF uf = new UF(n);
        int res = 0;
        for (int i = 0; i < edges.size(); i++) {
            int[] edge = edges.get(i);
            int u = edge[0], v = edge[1], w = edge[2];
            if (uf.union(u, v)) continue;
            res += w;
        }
        return res;
    }
    
}

class UF {
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
        return false;
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}