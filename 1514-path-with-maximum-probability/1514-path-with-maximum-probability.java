class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
       //build undirected weighted graph
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double w = succProb[i];
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w)); 
        }
        
        //init array - prob to each node from start_node
        boolean[] visited = new boolean[n];
        double[] dist = new double[n]; //probability to start_node
        Arrays.fill(dist, 0.0);
        dist[start_node] = 1.0;
        
        //dijkstra
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Double.compare(o2.w, o1.w)); //sort dist in descending order
        pq.add(new Node(start_node, 1.0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.v;
            double d = node.w;
            if (visited[u]) continue;
            visited[u] = true;
            if (u == end_node) return dist[u];
            for (Node neighbor : graph.get(u)) {
                int v = neighbor.v;
                double w = neighbor.w;
                if (!visited[v] && d * w > dist[v]) {
                    dist[v] = d * w;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        return 0;
    }
    
    class Node {
        int v;
        double w;
        public Node(int v, double w) { //vertex and its dist to start node
            this.v = v; 
            this.w = w;
        }
    }
}
//Time: O(v + e * log(v)); Space: O(v + e)