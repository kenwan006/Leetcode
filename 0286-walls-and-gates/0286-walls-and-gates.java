/** bfs **/
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m  = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                for (int[] dir : dirs) {
                    int i = cell[0], j = cell[1];
                    int ii = cell[0] + dir[0], jj = cell[1] + dir[1];
                    
                    if (ii < 0 || jj < 0 || ii >= m || jj >= n || rooms[ii][jj] == -1) continue;
                    
                    if (rooms[i][j] + 1 < rooms[ii][jj]) {
                        rooms[ii][jj] = rooms[i][j] + 1;
                        queue.offer(new int[]{ii, jj});
                    }
                }
            }
        }
    }
}