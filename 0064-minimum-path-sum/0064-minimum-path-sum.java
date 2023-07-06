class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int[] dp = new int[n]; //dp[j] - refers to the min path sum from top left to grid[i][j]
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) dp[j] = Math.min(dp[j], dp[j - 1]);
                dp[j] += grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
//Time: O(n ^ 2); Space: O(n)
