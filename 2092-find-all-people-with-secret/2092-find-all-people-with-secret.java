class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        
        UF uf = new UF(n);
        uf.union(0, firstPerson); //union person 0 and firstPereson when sharing secret
        
        int m = meetings.length;
        int i = 0;
        while (i < m) {
            int currTime = meetings[i][2];
            
            //find all meetings having the same meeting time as currTime
            //add them to a pool
            Set<Integer> pool = new HashSet<>();
            while (i < m && meetings[i][2] == currTime) {
                int x = meetings[i][0];
                int y = meetings[i][1];
                pool.add(x);
                pool.add(y);
                uf.union(x, y);
                i++;
            }
            
            //check each perseon in the pool, if connected with 0, then keep it because he can share the secret in the future meetings
            //if not connected with 0, then reset it because we don't want bring its current uf connection to affect future meetings
            for (int p : pool) {
                if (!uf.connected(p, 0)) uf.reset(p);
            }
        }
        
        //get all peresons connected with 0
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (uf.connected(j, 0)) res.add(j);
        }
        
        return res;
        
    }
    
    class UF {
        int n;
        int[] parent;
        
        public UF(int n) {
            this.n = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public boolean connected (int p, int q) {
            return find(p) == find(q);
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootQ] = rootP;
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public void reset(int x) {
            parent[x] = x;
        }
    }
}

