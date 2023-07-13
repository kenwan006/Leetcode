class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]); //sort by the connection time
        UF uf = new UF(n);
        for (int[] log : logs) {
            uf.union(log[1], log[2]);
            if (uf.count == 1) return log[0];
        }
        return -1;
    }
    
    class UF {
        int n;
        int[] parent;
        int count;
        
        public UF(int n) {
            this.n = n;
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public void union(int p, int q) {
            int rootP = find(p), rootQ = find(q);
            if (rootP == rootQ) return;
            if (rootP != rootQ) parent[rootP] = rootQ;
            count--;
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
//Time: O(n); Space: O(n)