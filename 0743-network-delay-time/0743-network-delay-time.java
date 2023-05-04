/** Dijkstra's **/
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //build graph
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] e : times) {
            int u = e[0], v = e[1], w = e[2];
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, w);
        }
        
        //distance of each node to the source k
        int dist[] = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[k] = 0;
        
        //put the node a heap according to its distance to source
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        heap.offer(new int[]{k, 0});
        
        //dijstra
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int u = curr[0], d = curr[1];
            if (!graph.containsKey(u)) continue;
            
            for (int v : graph.get(u).keySet()) {
                int w = graph.get(u).get(v);
                if (dist[v] == -1 || d + w < dist[v]) { 
                    dist[v] = d + w; //update the distance of ajdcent node v to the source k
                    heap.offer(new int[]{v, d + w});
                }
            }
        }
        
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == -1) return -1; //-1 means never been visited
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}
//Time: O(e * log(v) + v); Space: O(v + e)