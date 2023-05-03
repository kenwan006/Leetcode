/** Eulerian Path **/
class Solution {
    Map<String, PriorityQueue<String>> graph;
    LinkedList<String> path;
    public List<String> findItinerary(List<List<String>> tickets) {
        graph = new HashMap<>();
        path = new LinkedList<>();
        //build the graph for flights
        for (List<String> ticket : tickets) {
            String departure = ticket.get(0), arrival = ticket.get(1);
            graph.putIfAbsent(departure, new PriorityQueue<>());
            graph.get(departure).add(arrival);
        }
        
        dfs("JFK");
        return path;
    }
    
    //dfs - find the eulerian path
    public void dfs(String departure) {
        if (graph.containsKey(departure)) {
            PriorityQueue<String> arrivals = graph.get(departure);
            while (!arrivals.isEmpty()) {
                dfs(arrivals.poll());
            }
        }
        
        path.addFirst(departure);
    }
}
//Time: O(e * log(e / v)); Space: O(v + e)