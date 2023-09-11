class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1]; //1-indexed
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];
        
        //build graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList());
        for (int[] e : times) {
            int u = e[0], v =e[1], w = e[2];
            graph.get(u).add(new int[]{v, w}); 
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); //sort by dist to source node k
        pq.add(new int[]{k, 0});
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0], d = node[1];
            if (visited[u]) continue;
            visited[u] = true; //mark as visited
            if (--n == 0) return d;
                
            //check its neighbors
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0], w = neighbor[1];
                if (!visited[v] && d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.add(new int[]{v, dist[v]}); //add this node to pq for future check
                }
            }
        }
        return -1;
    }
}
//Time: O(v + e * log(v)); Space: O(v + e)