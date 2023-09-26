class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(i, j, grid);
                }
            }
        }
        return count;
    }
    
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private void bfs(int i, int j, char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for (int[] dir : dirs) { //check neighbors
                int ii = curr[0] + dir[0];
                int jj = curr[1] + dir[1];
                if (ii < 0 || jj < 0 || ii >= grid.length || jj >= grid[0].length || grid[ii][jj] == '0') continue;
                grid[ii][jj] = '0'; //mark as visited, turn '1' to '0'
                queue.add(new int[]{ii, jj});
            }
        }
    }
}