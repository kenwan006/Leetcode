/** dfs **/
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        int n = queries.size();
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            String s = queries.get(i).get(0), t = queries.get(i).get(1);
            res[i] = dfs(s, t, new HashSet<String>(), graph);
        }
        return res;
    }
    
    //dfs - find the value of path s -> t; return -1.0 if not found
    private double dfs(String s, String t, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(s) || !graph.containsKey(t)) return -1.0;
        if (graph.get(s).containsKey(t)) return graph.get(s).get(t);
        
        visited.add(s); //mark as visited
        for (String next : graph.get(s).keySet()) {
            if (visited.contains(next)) continue;
            double curr_weight = graph.get(s).get(next); //from s -> next 
            double next_weight = dfs(next, t, visited, graph); //from next -> t
            if (next_weight != -1.0) return curr_weight * next_weight;
        }
        return -1.0;
    }
    
    //build graph
    private Map<String, Map<String, Double>> buildGraph (List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String s = equations.get(i).get(0), t = equations.get(i).get(1);
            graph.putIfAbsent(s, new HashMap<>());
            graph.putIfAbsent(t, new HashMap<>());
            graph.get(s).put(t, values[i]);
            graph.get(t).put(s, 1 / values[i]);
        }
        return graph;
    }
}

//Time: O(m * n); Space: O(n)