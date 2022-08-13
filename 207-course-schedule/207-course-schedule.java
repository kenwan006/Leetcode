class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        
        // build the graph
        for(int i = 0; i < numCourses; i++) graph[i] = new ArrayList<Integer>();
        for(int[] preq : prerequisites) {
            int i= preq[1], j = preq[0];
            graph[i].add(j); // vertex i has the coming edge from vertex j, the prerequisite
            degree[j]++;
        }
        
        // topological sorting 
        for(int i = 0; i < numCourses; i++ ) {
            if(degree[i] == 0) queue.add(i); 
        }
        
        while(!queue.isEmpty()) {
            int i = queue.poll();
            count++; 
            for(int j : graph[i]) { //in-degree of each adjacent vertex decrements by 1
                degree[j]--;
                if(degree[j] == 0) queue.add(j);
            }  
        }
        
        return count == numCourses;
        
    }
}