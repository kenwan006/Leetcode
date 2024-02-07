class Solution {
    LinkedList<String> res;
    Map<String, PriorityQueue<String>> graph;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        res = new LinkedList<>();
        graph = new HashMap<>();
        
        //build the graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).add(to);
        }
        
        dfs("JFK");
        return res;
    }
    
    //post order traversal
    private void dfs(String departure) {
        PriorityQueue<String> arrivals = graph.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            String arrival = arrivals.poll(); //remvoe the visited itinerary
            dfs(arrival);
        }
        
        res.addFirst(departure);
    }
}