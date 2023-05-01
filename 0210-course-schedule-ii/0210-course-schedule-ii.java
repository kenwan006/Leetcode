/** Topological sorting **/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //build graph
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        int[] indeg = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
            indeg[to]++;
        }
        
        //find the vertices with 0 indegeree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) queue.offer(i);
        }
        
        //topological sorting
        int[] res = new int[numCourses];
        int i = 0; //count of courses added to the result
        while (!queue.isEmpty()) {
            int v = queue.poll();
            res[i++] = v;
            for (int u : graph[v]) {
                if (--indeg[u] == 0) {
                    queue.offer(u);
                }
            }
        }
        
        return i == numCourses? res : new int[0];
    }
}
//Time: O(v + e); Space: O(v + e)