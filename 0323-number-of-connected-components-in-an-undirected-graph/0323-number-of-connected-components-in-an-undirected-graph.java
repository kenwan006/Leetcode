class Solution {
    int[] parent;
    int[] size;
    int count;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        count = n;
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return count;
    }
    
    public void union(int p, int q) {
        int rootP = find(p), rootQ = find(q);
        if (rootP == rootQ) return;
        
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
//Time: O(v + e); Space: O(v)