class Solution {
    public int numEnclaves(int[][] grid) {
        // start from four boundaries
        // if the cell is '1', do dfs traversal, turn all its connected '1' to '0'
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) dfs(i, 0, grid);
            if (grid[i][n - 1] == 1) dfs(i, n - 1, grid);
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) dfs(0, j, grid);
            if (grid[m - 1][j] == 1) dfs(m - 1, j, grid);
        }
        
        //check the remaining lands '1'
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        return count;
    }
    
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private void dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            dfs(i + dir[0], j + dir[1], grid);
        }
    }
}
// O(m * n); Space: O(m + n)
