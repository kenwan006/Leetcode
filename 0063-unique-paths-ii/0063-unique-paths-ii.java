class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n]; //dp[i][j] - refers to the number of path from top left to grid[i][j]
        if (obstacleGrid[0][0] == 0) dp[0][0] = 1; //starting point could be an obstacle
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue; // skip the obstacle
                if (i > 0 && obstacleGrid[i - 1][j] == 0) dp[i][j] += dp[i - 1][j];
                if (j > 0 && obstacleGrid[i][j - 1] == 0) dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
//Time: O(n ^ 2); Space: O(n ^ 2)