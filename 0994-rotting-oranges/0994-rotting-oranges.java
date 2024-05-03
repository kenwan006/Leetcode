class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int fresh = 0; // count of fresh orange
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }
        
        //start rotting
        int time = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int i = curr[0], j = curr[1];
                for (int[] dir : dirs) {
                    int ii = i +  dir[0], jj = j + dir[1];
                    if (ii < 0 || jj < 0 || ii >= m || jj >= n || grid[ii][jj] == 0 || grid[ii][jj] == 2) continue;
                    grid[ii][jj] = 2; //fresh orange rot
                    fresh--;
                    queue.offer(new int[]{ii, jj});
                }
            }
            time++;
        }
        return fresh == 0? time : -1;
    }
}

//Time: O(m * n); Space: O(m * n)