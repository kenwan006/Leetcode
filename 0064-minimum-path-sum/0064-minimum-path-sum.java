class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int[][] dp = new int[m][n]; //dp[i][j] - refers to the  min path sum from top left to grid[i][j]
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) dp[i][j] = dp[i - 1][j];
                if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                dp[i][j] += grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
//Time: O(n ^ 2); Space: O(n ^ 2)
