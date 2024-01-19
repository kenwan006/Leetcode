class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] indeg = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for (int[] e : prerequisites) {
            int from = e[1], to = e[0];
            indeg[to]++;
            graph[from].add(to);
        }
        
        //init queue - vertices with 0 indeg
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) queue.offer(i);
        }
        
        int[] res = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll(); //take the course 
            res[idx++] = node;
            for (int adj : graph[node]) {
                if (--indeg[adj] == 0) queue.offer(adj);
            }
        }
        return idx == numCourses? res : new int[0];
    }
}