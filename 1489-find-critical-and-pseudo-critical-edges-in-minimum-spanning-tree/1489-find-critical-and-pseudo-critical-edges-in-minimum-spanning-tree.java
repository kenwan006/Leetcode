/** MST - kruskal's
* Run krusal's algo to get the standard mst value
* Iterate over the edges, skip one edge that won't be added to mst. Run kruksal's - 
* If we can't get a valid mst, or can get a mst but with mst value > standard mst value, then this edge is cirtical
* Else if it's not critical, we force a mst to include this edge. If still can get a valid mst and its value == stardard mst value, then it's pseudo-critical edge
**/
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> criticals = new ArrayList<>();
        List<Integer> pseudos = new ArrayList<>();
        
        //build the graph with edge's index added
        int m = edges.length;
        int[][] newEdges = new int[m][4]; // {u, v, w, i}
        for (int i = 0; i < m; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            newEdges[i] = new int[]{u, v, w, i};
        }
        Arrays.sort(newEdges, (o1, o2) -> o1[2] - o2[2]); //sort edges by weight
        
        //stardard mst
        int mst = buildMST(n, newEdges, -1, -1); //-1 means null
        
        //for each edge, check if it's critical or pseudo-critical
        for (int i = 0; i < m; i++) {
            int index = newEdges[i][3]; 
            if (buildMST(n, newEdges, i, -1) > mst) criticals.add(index); //do not add i; order of i shuffled after sorting newEdges
            else {
                if (buildMST(n, newEdges, -1, i) == mst) pseudos.add(index);
            }
        }
        res.add(criticals);
        res.add(pseudos);
        return res;  
    }
    
    // find the mst for the given edges
    public int buildMST(int n, int[][] edges, int skip, int pick) {
        UF uf = new UF(n);
        int mst = 0;
        int count = 0; //count of edges added to mst
        if (pick != -1) {
            uf.union(edges[pick][0], edges[pick][1]);
            mst += edges[pick][2];
            count++;
        }
        for (int i = 0; i < edges.length; i++) {
            if (skip == i) continue;
            if (uf.union(edges[i][0], edges[i][1])){
                mst += edges[i][2];
                count++;
            }
        }
        return count == n - 1? mst : Integer.MAX_VALUE;
    }
    
    class UF {
        int[] parent;
        //int[] size - if need to make the tree more balanced
        public UF(int V) {
            parent = new int[V];
            for (int i = 0; i < V; i++) parent[i] = i;
        }
        private boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return false;
            parent[rootP] = rootQ;
            return true;
        }
        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
//Time: O(e * e * v + e * log(e)); Space: O(v + e)