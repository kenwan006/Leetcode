/** Topological sorting **/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build graph
        List<Integer>[] graph = new List[numCourses];
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>(); //each item has to be intialized!!
        for (int edge[] : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
            indeg[to]++;
        }
        
        //find vertices with 0 indegree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) queue.offer(i);
        }
        
        //topological sorting
        int count = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;
            for (int v : graph[u]) {
                if (--indeg[v] == 0) {
                    queue.add(v);
                }
            }
        }
        
        return count == numCourses;
    }
}
//Time: O(v + e); Space: O(v)