class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = {{-1, 0},{1, 0},{0, -1}, {0, 1},{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        
        int step = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                if (cell[0] == n - 1 && cell[1] == n - 1) return step;
                for (int[] dir : dirs) {
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];
                    if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] == 1) continue;
                    grid[r][c] = 1; //use 1 as marked
                    queue.add(new int[]{r, c});
                }
            }
            step++;
        }
        return -1;
    }
}