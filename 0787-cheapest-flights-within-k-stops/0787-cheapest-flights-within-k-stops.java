/** Dijkstra's **/
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //build graph
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] e : flights) {
            int u = e[0], v = e[1], w = e[2];
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, w);
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        
        //bfs
        while (k >= 0 && !queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int u = curr[0], d = curr[1];
                
                if (!graph.containsKey(u)) continue;
                
                for (int v : graph.get(u).keySet()) {
                    int w = graph.get(u).get(v);
                    if (d + w < dist[v]) {
                        dist[v] = d + w;
                        queue.offer(new int[]{v, d + w});
                    }
                }
            }
            k--;
        }
        return dist[dst] == Integer.MAX_VALUE? -1 : dist[dst];
    }
}
//Time: O(v + e * k); Space: O(v + e)
