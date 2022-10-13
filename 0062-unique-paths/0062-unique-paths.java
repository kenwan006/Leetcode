/** DP
* To move to position(i, j), we have to first move to either (i-1,j) or (i, j-1),
* Total ways to dp[i][j] = dp[i-1][j] + dp[i][j-1]
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //Base case - first row and first column
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                // This is equivalent to dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}