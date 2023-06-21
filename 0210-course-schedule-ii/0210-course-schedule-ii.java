class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        //construct the graph
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for (int[] e : prerequisites) {
            int u  = e[1], v = e[0];
            graph[u].add(v);
            indeg[v]++;
        }
        
        //find the vertices with 0 indeg
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) queue.offer(i);
        }
        
        //toplogical sorting\
        int ctn = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph[u]) {
                if (--indeg[v] == 0) queue.offer(v);
            }
            res[ctn++] = u;
        }
        
        return ctn == numCourses? res : new int[]{};
    }
}