class Solution {
    public int numIslands(char[][] grid) {
        int ctn = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') continue;
                ctn++;
                dfs(grid, i, j);
            }
        }
        return ctn;
    }
    
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
        
        grid[i][j] = '0'; //swallow the island
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
     }
}

//Time: O(m * n); Space: O(m * n)
