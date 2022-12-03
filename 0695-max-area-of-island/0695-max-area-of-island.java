/** DFS */

class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i , j));
                }
            }
        }
        return maxArea;
    }
    
    //dfs to calculat the area for each group of islands
    public int dfs(int[][] grid, int i , int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
        
        int area = 1;
        grid[i][j] = 0; // swallow the island
        for (int[] dir : dirs) {
            area += dfs(grid, i + dir[0], j + dir[1]);
        } 
        return area;
    }
}

//Time: O(m * n); Space: O(m * n)