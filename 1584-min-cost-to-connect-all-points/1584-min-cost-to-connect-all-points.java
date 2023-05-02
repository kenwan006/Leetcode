/** MST 
* connect every two points, and sorting their length in ascending order. 
* Everytime add the minimum edge to the mst if it's not been added previously.
**/
class Solution {
    public int minCostConnectPoints(int[][] points) {
        //edges between every two points i and j
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d =  Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, d});
            }
        }
        Collections.sort(edges, (a, b) -> a[2] - b[2]); //sort the edge by their length
        
        //kruskal algo
        UF uf = new UF(n);
        int mst = 0;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], d = edge[2];
            if (!uf.union(u, v)) continue; //cycle detected when u and v already connected in mst
            mst += d; 
        }
        return mst;
        
    }
    
    class UF {
        int[] parent;
        int[] size;
        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public boolean union(int p, int q) {
            int rootP = find(p), rootQ = find(q);
            if (rootP == rootQ) return false;
            
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
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
//Time: O(n ^2 * log(n)); Space: O(n ^2)