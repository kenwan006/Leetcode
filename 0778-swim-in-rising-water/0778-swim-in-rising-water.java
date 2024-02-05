class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> grid[o1[0]][o1[1]] - grid[o2[0]][o2[1]]);
        pq.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[m][n];
        
        int water = 0; // water elevation
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0], j = curr[1];
            water = Math.max(water, grid[i][j]);
            if (i == m - 1 && j == n - 1) return water;
            for (int[] dir : dirs) {
                int ii = i + dir[0], jj = j + dir[1];
                if (ii < 0 || ii >= m || jj < 0 || jj >= n || visited[ii][jj]) continue;
                visited[ii][jj] = true;
                pq.offer(new int[]{ii, jj});
            }
        }
        return water;
    }
}