/** Prim MST **/
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        
        //build the graph
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                int w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new int[]{j, w});
                adj.get(j).add(new int[]{i, w});
            }
        }
        
        //prim mst
        int mst = 0;
        boolean[] inMST = new boolean[V];
        inMST[0] = true; //pick the vertex 0 as the start
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (int[] e : adj.get(0)) pq.offer(e);
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int v = curr[0], w = curr[1];
            if (inMST[v]) continue;
            inMST[v] = true;
            mst += w;
            for (int[] e : adj.get(v)) {
                if (!inMST[e[0]]) {
                    pq.offer(e);
                }
            }
        }
        
        return mst;
    }
}
//Time: O(n * n * log(n)); Space: (n * n)  n - number of points