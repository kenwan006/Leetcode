class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                //Once found '1', increment count by 1 and do DFS
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i , j);
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || grid[i][j] == '0') return; // base case
        grid[i][j] = '0'; // change '1' to '0'
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}