class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return dfs(i, j, grid);
            }
        }
        return -1;
    }
    
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    // dfs 
    // if the neighboring cell of an island is water or out of boundary, then return 1
    // if the neighboring cell has been visited, return 0 to avoid duplicate count
    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 1;
        if (grid[i][j] == 2) return 0;
        
        grid[i][j] = 2; //if visited, mark as 2
        int count = 0;
        for (int[] dir : dirs) {
            count += dfs(i + dir[0], j + dir[1], grid);
        }
        return count;
    }
}
//Time: O(m * n); Space: O(m + n)
