/** UF 
* If there is node with indegree of 2, then we have to remove one of edge pointing to this node;
* If every node has 1 indegree, then there must exist a cycle. Remove one edge to break the cycle
*/
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        
        //check indeg
        int[] indeg = new int[n + 1];
        int nodeWithTwoIndeg = -1; 
        for (int[] e : edges) {
            int v = e[1];
            if (++indeg[v] == 2) {
                nodeWithTwoIndeg = v; //find the node with two indegs
                break;
            }
        }
        
        if (nodeWithTwoIndeg == -1) { //cycle exists
            return findRemovedEdge(edges);
        } else {
            //remove one edge pointing two this node, and check if a tree can still be formed
            for (int i = n - 1; i >= 0; i--) {
                if (edges[i][1] != nodeWithTwoIndeg) continue;
                if (isTreeAfterRemoval(edges[i], edges)) return edges[i];
            }
        }
        return null;
    }
    
    private boolean isTreeAfterRemoval(int[] remove, int[][] edges) {
        int n = edges.length;
        UF uf = new UF(n);
        for (int[] e : edges) {
            if (e == remove) continue;
            if(uf.union(e[0], e[1])) return false;
        }
        return true;
    }
    
    private int[] findRemovedEdge(int[][] edges) {
        int n = edges.length;
        UF uf = new UF(n);
        for (int[] e : edges) {
            if (uf.union(e[0], e[1])) return e;
        }
        return null;
    }
    
    class UF {
        int[] parent;
        public UF(int n) {
            parent = new int[n + 1]; //0, 1, 2..n
            for (int i = 0; i <= n; i++) parent[i] = i;
        }
        private boolean union(int p, int q) { //p -> q
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return true;
            parent[rootQ] = rootP; //can't use parent[rootP] = rootQ
            return false;
        }
        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}