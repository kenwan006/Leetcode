/** Graph + DFS **/
class Solution {
    
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        
        //build the graph
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
            for (int j = i + 1; j < n; j++) {
                long x2 = bombs[j][0], y2 = bombs[j][1], r2 = bombs[j][2];
                long dist =(x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                //a bomb will be only detonated when its origin is within the affected area of the other bomb
                if (dist <= r1 * r1) graph[i].add(j);
                if (dist <= r2 * r2) graph[j].add(i);
            }
        }
        
        //start from each node and dfs
        int maxCount = 1;
        for (int i = 0; i < n; i++) maxCount = Math.max(maxCount, dfs(i, graph, new boolean[n]));
        return maxCount;
    }
    
    //dfs - find the max nodes can ben visited
    private int dfs(int i, List<Integer>[] graph, boolean[] visited) {
        if (visited[i]) return 0;
        
        visited[i] = true;
        int count = 1;
        for (int j : graph[i]) {
            count += dfs(j, graph, visited);
        }
        return count;
    }
}
//Time: O(v *(v + e)); Space: O(e)