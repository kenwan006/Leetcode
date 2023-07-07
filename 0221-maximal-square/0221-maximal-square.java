class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //dp[i][j] - refers to the edge length of the square with all 1s ending with right bottom at matrix[i-1][j-1]
        int[][] dp = new int[m + 1][n + 1]; 
        int maxLen = 0;
        
        //base case
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '0') continue; //do not use matrix[i][j] for current cell
                
                //find the min among left square, upper sqaure and upper-left square
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen * maxLen;
    }
}
//Time: O(m * n); Space: O(m * n)

