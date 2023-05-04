/** Dijkstra's **/
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //build graph
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>(); // u -> {{v1, w1}, {u2, w2},..}
        for (int e[] : times) {
            int u = e[0], v = e[1], w = e[2];
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, w);
        }
        
        //ues a heap to store the v with its distance to the source, {u, dist}
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        heap.offer(new int[]{k, 0});
        
        //dijkstra
        int res = 0;
        boolean[] visited = new boolean[n + 1];
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int u = curr[0], dist = curr[1];
            
            if (visited[u]) continue;
            res = dist; //the max dist will be popped at the end of the loop
            visited[u] = true;
            n--; //need to visit all n nodes
            
            if (!graph.containsKey(u)) continue;
            for (int v : graph.get(u).keySet()) {
                if (!visited[v]) heap.offer(new int[]{v, dist + graph.get(u).get(v)});
                //A node can be added more than once with different distances to source, 
                //but only the smallest one will be used because it will be popped out earliest from the heap, and marked as visited
            }
        }
        return n == 0? res : -1;
    }
}
//Time: O(e + e * log(v)); Space: O(v + e)