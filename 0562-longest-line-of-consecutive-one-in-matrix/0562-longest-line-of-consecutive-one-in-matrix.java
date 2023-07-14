/** dp **/
class Solution {
    public int longestLine(int[][] mat) {
        int m = mat.length,n = mat[0].length;
        //The third dimension refers to 4 status - max one on vertical, horizontal, diagonal and anti-diagonal
        //dp[i][j][k] - refers to the longest consecutive ones ending at matrix[i][j] for status k
        int[][][] dp = new int[m][n][4];
        int ones = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) continue; //ending with 0 will have consecutive length to be 0
                dp[i][j][0] = i > 0? dp[i - 1][j][0] + 1 : 1;
                dp[i][j][1] = j > 0? dp[i][j - 1][1] + 1 : 1;
                dp[i][j][2] = i > 0 && j > 0? dp[i - 1][j - 1][2] + 1 : 1;
                dp[i][j][3] = i > 0 && j < n - 1? dp[i - 1][j + 1][3] + 1 : 1;
                ones = Math.max(ones, Math.max(Math.max(dp[i][j][0], dp[i][j][1]), Math.max(dp[i][j][2], dp[i][j][3])));
            }
        }
        return ones;
    }
}
//Time: O(m * n); Space: O(m * n)