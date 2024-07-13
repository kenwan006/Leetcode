class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //build graph
        List<Integer>[] g = new List[numCourses];
        for (int i = 0; i < numCourses; i++) g[i] = new ArrayList<>();
        int[] indeg = new int[numCourses];
        for (int[] e : prerequisites) {
            int from = e[1], to = e[0];
            g[from].add(to);
            indeg[to]++;
        }
        
        //find the nodes with 0 indeg
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) queue.offer(i);
        }
        
        //toplogical sorting
        int count = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int curr= queue.poll();
            res[count++] = curr;
            for (int adj : g[curr]) {
                if (--indeg[adj] == 0) queue.offer(adj);
            }
        }
        return count == numCourses? res : new int[0];
    }
}