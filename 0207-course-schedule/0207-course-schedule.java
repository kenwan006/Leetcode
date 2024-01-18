class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> [] graph = new List[numCourses];
        int[] indeg = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for (int[] e : prerequisites) {
            int from = e[1], to = e[0];
            indeg[to]++;
            graph[from].add(to);
        }
        
        //init queue - all vertices with indeg 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) queue.offer(i);
        }
        
        int count = 0;
        while(!queue.isEmpty()) {
            int i = queue.poll(); //take course i
            for (int adj : graph[i]) {
                if (--indeg[adj] == 0) queue.offer(adj);
            }
            count++;
        }
        
        return count == numCourses;
    }
}