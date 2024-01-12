class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j, grid);
                }
            }
        }
        return res;
    }
    
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    private void dfs(int i, int j, char[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        
        //change land to water
        grid[i][j] = '0';
        
        for (int[] dir : dirs) {
            dfs(i + dir[0], j + dir[1], grid);
        }
    }
}