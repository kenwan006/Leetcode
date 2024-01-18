class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int step = -1; 
        int count = 0; //count of fresh orange
        //put all the rotton orangs to a queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.add(new int[]{i, j});
                if (grid[i][j] == 1) count++;
            }
        }
        
        if (count == 0) return 0; //no fresh orange left in the beginning
        
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        
        //start rotting the fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0], c = curr[1] + dir[1];
                    if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0 || grid[r][c] == 2) continue;
                    grid[r][c] = 2; //rot the fresh orange
                    count--;
                    queue.offer(new int[]{r, c});
                }
            }
            step++; // the final loop should not be counted
        }
        
        return count == 0? step : -1;
    }
}