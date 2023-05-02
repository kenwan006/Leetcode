/** Dijkstra's algo *
* For each vertex, find their min distance from the source vertex k
**/
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //build a DAG graph
        List<List<int[]>> graph = new ArrayList<>(); // node v -> all its adjacent nodes {[u1, w1], [u2, w2]...}
        for (int v = 0; v <= n; v++) graph.add(new ArrayList<>());
        for (int[] edge : times) {
            int v = edge[0], u = edge[1], w= edge[2];
            graph.get(v).add(new int[]{u, w});
        }
        
        //distance of each node to the sorce node
        int[] dist = new int[n + 1]; //1-indexed
        for (int i = 0; i <= n; i++) dist[i] = -1;
        dist[k] = 0;
        
        //dijkstra
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]); //{i, dist[i]}
        heap.offer(new int[]{k, 0});
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int u = curr[0], d = curr[1]; //distance from source to u
            for (int[] adj : graph.get(u)) {
                int v = adj[0], w = adj[1]; //edge u -> v with length w
                if (dist[v] == -1 || d + w < dist[v]) {
                    dist[v] = d + w;
                    heap.offer(new int[]{v, d + w});
                }
            }
        }
        
        //find the max distance
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == -1) return -1; // node never updated/visited
            res = Math.max(res, dist[i]);
        }
        return res;
    
    }
}
//Time: O(v + e); Space: O(v + e)