class Solution {   
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        int m = grid.length, n = grid[0].length, fresh = 0, t = 0, ans = 0;
        
        // create a queue to store all rotten oranggs and count total fresh orange
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 2) rotten.add(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }
        
        // start bfs rotting
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 4-directionally adjacent neighbors
        while (!rotten.isEmpty()) {
            if (fresh == 0) break;
            int size = rotten.size();
            // At each timestamp pop out all rotten oranges
            for(int i = 0; i < size; i++) {
                int[] cell = rotten.poll();
                for (int[] dir : dirs) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    if(x < 0 || x > m - 1 || y < 0 || y > n - 1) continue;
                    if (grid[x][y] == 1) {
                        grid[x][y] = 2;
                        rotten.add(new int[]{x, y});  // rot the fresh orange and add to the queue
                        fresh--;
                    }   
                }
            }  
            t++;
        }
        
        ans = fresh == 0 ? t : -1;
        return ans;
    }
}