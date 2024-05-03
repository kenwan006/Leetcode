class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        
        int[] indeg = new int[numCourses];
        
        //build the graph and indeg
        for (int[] e : prerequisites) {
            int from  = e[1], to = e[0];
            graph[from].add(to);
            graph[to].add(from);
            
            indeg[to]++;
        }
        
        //find the node with 0 indeg
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) queue.offer(i);
        }
        
        //topological sorting
        int count = 0; // count the courses selected
        while (!queue.isEmpty()) {
            int src = queue.poll();
            count++; 
            
            //update indeg for adjacents of src if we remove the src
            for (int adj : graph[src]) {
                if (--indeg[adj] == 0) queue.offer(adj);
            }
            
        }
        
        return count == numCourses;
    }
}

//Time: O(v + e); Space: O(v + e)