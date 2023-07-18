/** Union Find + TreeMap **/
class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        
        //use a treeMap to map val to the nodes which share the same val
        Map<Integer, List<Integer>> valsToNodes = new TreeMap<>(); 
        for (int i = 0; i < n; i++) {
            valsToNodes.putIfAbsent(vals[i], new ArrayList<>());
            valsToNodes.get(vals[i]).add(i);
        }
        
        //construct the adj list
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            //for the node u - only consider the neighbors with smaller or equal vals
            if (vals[u] >= vals[v]) adj[u].add(v);
            else adj[v].add(u);
        }
        
        //find the path - start from the smallest val
        UF uf = new UF(n);
        int res = 0;
        for (int val : valsToNodes.keySet()) {
            List<Integer> nodes = valsToNodes.get(val);
            for (int u : nodes) {
                for (int v : adj[u]) { //value of u >= v
                    uf.union(u, v);
                }
            }
            //count how many connected components formed by nodes with the same vals
            Map<Integer, Integer> counts = new HashMap<>();
            for (int u : nodes) {
                int root = uf.find(u);
                counts.put(root, counts.getOrDefault(root, 0) + 1);
            }
            //In each component, check how many nodes with this val
            int total = nodes.size(); // path - single node
            for (int u : counts.keySet()) {
                int count = counts.get(u);
                total += (count - 1) * count / 2; //path - start and end node with the same val
            }
            res += total;
        }
        return res;
        
    }
    
    class UF {
        int[] parent;
        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public void union(int p, int q) {
            int rootP = find(p), rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
        }
        
        public int find(int x) {
            if (x != parent[x]) parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}