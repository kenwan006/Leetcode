/** Dijkstra's  **/
class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        //init dist and pq
        int m = maze.length, n = maze[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[start[0]][start[1]] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]); //{x, y, dist}
        pq.offer(new int[]{start[0], start[1], 0}); 
        
        //dijkstra
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], d = curr[2];
            if (dist[x][y] < d) continue;
            if (x == destination[0] && y == destination[1]) return d;
            
            for (int[] dir : dirs) {
                int xx = x + dir[0], yy = y + dir[1], steps = 0;
                //rolling and find the stop position
                while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
                    xx += dir[0];
                    yy += dir[1];
                    steps++;
                }
                //roll back one step
                xx -= dir[0];
                yy -= dir[1];
                
                if (dist[x][y] + steps < dist[xx][yy]) {
                    dist[xx][yy] = dist[x][y] + steps;
                    pq.offer(new int[]{xx, yy, dist[xx][yy]});
                }
            }  
        }
        return -1;
    }
}